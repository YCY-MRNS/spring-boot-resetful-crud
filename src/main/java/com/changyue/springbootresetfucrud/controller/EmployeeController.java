package com.changyue.springbootresetfucrud.controller;

import com.changyue.springbootresetfucrud.dao.DepartmentDao;
import com.changyue.springbootresetfucrud.dao.EmployeeDao;
import com.changyue.springbootresetfucrud.entities.Department;
import com.changyue.springbootresetfucrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @program: spring-boot-restful-crud
 * @description: 员工控制器
 * @author: YuanChangYue
 * @create: 2019-08-14 14:20
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 获得全部员工
     */
    @GetMapping("/emps")

    public String list(Model model) {

        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);

        return "emp/list";
    }

    /**
     * 去添加员工页面
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {

        //查询部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dep", departments);

        return "emp/edit";
    }

    /**
     * 添加员工
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        System.out.println(employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    /**
     * 去员工编辑页面
     */
    @GetMapping("emp/{id}")
    public String toEditPage(@PathVariable Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        //查询部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dep", departments);
        return "emp/edit";
    }

    /**
     * 修改员工数据
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("employee = " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}

