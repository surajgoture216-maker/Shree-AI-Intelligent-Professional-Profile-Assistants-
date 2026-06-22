package shree_ai_backend.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shree_ai_backend.admin.dto.PromptRequest;
import shree_ai_backend.admin.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/prompt")
    public String processPrompt(@RequestBody PromptRequest request) {
        return adminService.processPrompt(request);
    }
}