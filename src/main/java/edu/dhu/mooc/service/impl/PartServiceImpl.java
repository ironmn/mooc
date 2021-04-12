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
}
