package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/save")
    public Admin save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @GetMapping("/read/{adminId}")
    public Admin read(@PathVariable("adminId") Long adminId) {
        return adminService.read(adminId);
    }

    @PostMapping("/update")
    public Admin update(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @DeleteMapping("/delete/{adminId}")
    public boolean delete(@PathVariable Long adminId) {
        return adminService.deleteById(adminId);
    }

    @GetMapping("/getAll")
    public List<Admin> getAll() {
        return adminService.getAll();
    }
}
