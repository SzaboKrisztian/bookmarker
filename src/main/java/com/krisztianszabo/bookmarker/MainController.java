package com.krisztianszabo.bookmarker;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {
  private final LinkRepository links;

  public MainController(LinkRepository links) {
    this.links = links;
  }

  @GetMapping("/")
  public String displayPage(Model model) {
    model.addAttribute("allLinks", links.findAll());
    model.addAttribute("singleLink", new Link());
    return "index";
  }

  @GetMapping("/edit/{link_id}")
  public String editLink(Model model, @PathVariable("link_id") Integer linkId) {
    Optional<Link> theLink = links.findById(linkId);
    if (theLink.isPresent()) {
      model.addAttribute("allLinks", links.findAllByOrderByIdAsc());
      model.addAttribute("singleLink", theLink.get());
      return "index";
    } else {
      return "redirect:/";
    }
  }

  @PostMapping("/save")
  public String saveLink(@ModelAttribute Link link) {
    links.save(link);
    return "redirect:/";
  }

  @GetMapping("/delete/{link_id}")
  public String deleteLink(@PathVariable("link_id") Integer linkId) {
    links.deleteById(linkId);
    return "redirect:/";
  }
}
