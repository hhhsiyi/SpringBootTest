package springcloud.service;

import com.hewen.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById1(Long id);

    public List<Dept> queryAll();
}
