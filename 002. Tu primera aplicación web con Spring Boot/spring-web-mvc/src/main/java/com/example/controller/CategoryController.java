package com.example.controller;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Category> categories = this.categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }

    @GetMapping("/new")
    public String getForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }

    @PostMapping
    public String save(@ModelAttribute("category") Category category) {
        this.categoryRepository.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id}/view")
    public String getCategory(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "category-view";
        } else {
            redirectAttributes.addFlashAttribute("message", "Categoría no encontrada");
            redirectAttributes.addFlashAttribute("alert", "warning");
            return "redirect:/categories";
        }
    }

    @GetMapping("/{id}/edit")
    public String editCategory(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "category-edit";
        } else {
            redirectAttributes.addFlashAttribute("message", "Categoría no encontrada");
            redirectAttributes.addFlashAttribute("alert", "warning");
            return "redirect:/categories";
        }
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        this.categoryRepository.save(category);
        redirectAttributes.addFlashAttribute("message", "Categoría modificada con éxito");
        redirectAttributes.addFlashAttribute("alert", "success");
        return "redirect:/categories";
    }
    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "category-delete";
        } else {
            redirectAttributes.addFlashAttribute("message", "Categoría no encontrada");
            redirectAttributes.addFlashAttribute("alert", "warning");
            return "redirect:/categories";
        }
    }
    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        this.categoryRepository.delete(category);
        redirectAttributes.addFlashAttribute("message", "Categoría eliminada con éxito");
        redirectAttributes.addFlashAttribute("alert", "success");
        return "redirect:/categories";
    }

    @GetMapping("/delete/all")
    public String deleteAllQuest(Model model) {
        model.addAttribute("total", this.categoryRepository.count());
        return "category-delete-all";
    }

    @PostMapping("/delete/all")
    public String deleteAll(RedirectAttributes redirectAttributes) {
        this.categoryRepository.deleteAll();
        redirectAttributes.addFlashAttribute("message", "Todas las categorías han sido eliminadas.");
        redirectAttributes.addFlashAttribute("alert", "success");
        return "redirect:/categories";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Category> categories = this.categoryRepository.findByDescriptionContaining(query);
        model.addAttribute("categories", categories);
        return "category-search";
    }
}
