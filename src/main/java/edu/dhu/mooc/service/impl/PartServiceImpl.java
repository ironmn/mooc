package edu.dhu.mooc.service.impl;

import edu.dhu.mooc.dao.PartMapper;
import edu.dhu.mooc.entity.Part;
import edu.dhu.mooc.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/12 15:11
 * @describe
 */
@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartMapper partMapper;

    @Override
    public boolean hasCoursePartIndex(String c_id,Integer p_index) {
        List<Part> list = partMapper.getPartListByCourseId(c_id);
        for(Part p : list){
            if(p_index.equals(p.getP_index())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addNewPart(Part part) {
        String p_id = part.getC_id()+"_"+part.getP_index();
        part.setP_id(p_id);
        //如果说，通过主键进行查询，发现已经存在该章节列表了，那么就返回false
        if( partMapper.selectByPrimaryKey(part.getP_id()) != null){
            return false;
        }
        //如果没有，就插入对应的章节信息
        partMapper.insert(part);
        return true;
    }

    //实现删除章节的业务逻辑
    @Override
    public boolean deletePart(String p_id) {
        if(partMapper.selectByPrimaryKey(p_id) == null){
            //如果章节不存在，就返回false
            return false;
        }
        partMapper.deleteByPrimaryKey(p_id);
        //返回true表示删除成功
        return true;
    }
}
