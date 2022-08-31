package com.example.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.Controller.utils.Result;
import com.example.domain.TUser;
import com.example.service.TUserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    @GetMapping
    public Result getall(){
        System.out.println("test hot deploy.....");

        return new Result(true,tUserService.list());
    }

    @GetMapping("{id}")
    public Result selectById(@PathVariable Long id){
        return new Result(true,tUserService.getById(id));
    }

    @PostMapping
    public Result add(@RequestBody TUser tUser){
        return new Result(tUserService.save(tUser));
    }
    @PutMapping
    public Result update(@RequestBody TUser tUser){
        return new Result(tUserService.updateById(tUser));
    }

    @GetMapping("{currentPage}/{Pagesize}")
    public Result getPage(@PathVariable Integer currentPage,@PathVariable Integer Pagesize,TUser tUser){
        IPage<TUser> page = tUserService.getPage(currentPage, Pagesize,tUser);
        if(currentPage>page.getPages()){
            page=tUserService.getPage((int)page.getPages(),Pagesize,tUser);
        }
        return new Result(true,page);
    }
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Long id) throws IOException {
        if(id==1L) throw new IOException();
        return new Result(tUserService.removeById(id));

    }

    @PostMapping("{id}")
    public Result test(@PathVariable Integer id) throws IOException {
        if(true) throw new IOException();
        return new Result(true);

    }

}
