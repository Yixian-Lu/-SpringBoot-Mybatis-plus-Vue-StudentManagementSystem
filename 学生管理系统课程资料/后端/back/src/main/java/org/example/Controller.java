// 配置路由规则
package org.example;

import com.google.gson.Gson;
import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("all") // 去掉gson 警告
@CrossOrigin(origins = {"*", "null"})  // * 代表任何地方发来的请求都可以响应
public class Controller {
    @Autowired // 自动接线：mybatis-plus自动寻找mapper，对应上实体类， 从而操作数据库
    private StudentMapper studentMapper; // 通过mapper操作数据库
    private Gson gson=new Gson(); //查得数据转为字符串
    // Get 请求
    @GetMapping("/students") //走下面的函数
    public String getStudents(){
        //重点句型
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students); // 配置路由规则
    }
    @PostMapping("/add")
    public  void addStudent(@RequestBody Student student){
        studentMapper.insert(student);
    }
    @PostMapping("delete")
    public void removeStudent(@RequestBody Student student){
        studentMapper.deleteById(student);
    }
    @PostMapping("update")
    public void updateStudent(@RequestBody Student student){
        studentMapper.updateById(student);
    }
}
