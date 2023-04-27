package br.edu.utfpr.nf.controller;

import br.edu.utfpr.nf.dto.CategoriaDTO;
import br.edu.utfpr.nf.model.Categoria;
import br.edu.utfpr.nf.service.CategoriaService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Obter todas as categorias de forma paginada.
     *
     * @param pageable
     * @return
     */
    @GetMapping
    //public ResponseEntity<List<Categoria>> getAll() { // Sem paginação
    public ResponseEntity<Page<Categoria>> getAll(@PageableDefault(page = 0, size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok().body(categoriaService.findAll(pageable));
    }

    /**
     * Obter categorias por nome
     *
     * @param nome
     * @return
     */
    @GetMapping("/nome/{nome}")
    //public List<Categoria> getByNome(@RequestParam(required = false, defaultValue = "") String nome) {
    public List<Categoria> getByNome(@PathVariable(name = "nome") String nome) {
        return categoriaService.findByNome(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        var categoria = categoriaService.findById(id);

        if (!categoria.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não existe");
        }
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> save(@RequestBody @Valid CategoriaDTO categoriaDTO) {

        /**
         * Verifica se o nome já está em uso
         */
        if (categoriaService.existsByNome(categoriaDTO.getNome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: O nome já está em uso");
        }

        var categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDTO, categoria);
        categoria.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        var categoria = categoriaService.findById(id);

        if (!categoria.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não existe");
        }
        categoriaService.delete(categoria.get());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        var categoria = categoriaService.findById(id);

        if (!categoria.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não existe");
        }

        // Verificar se já existe uma categoria com este nome
        if (categoriaService.existsByNome(categoriaDTO.getNome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: O nome já está em uso");
        }

        // Modo 1: Copiar o objeto armazanado no banco e setar todas as propriedades
        /*
        var categoriaToUpdate = categoria.get();
        categoriaToUpdate.setNome(categoriaDTO.getNome());
         */
        // Modo 2: Criar um novo objeto, copiar os valores do DTO e setar os atributos imutáveis
        var categoriaToUpdate = new Categoria();
        BeanUtils.copyProperties(categoriaDTO, categoriaToUpdate);
        categoriaToUpdate.setId(categoria.get().getId());
        categoriaToUpdate.setCreatedAt(categoria.get().getCreatedAt());

        return ResponseEntity.ok().body(categoriaService.save(categoriaToUpdate));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
