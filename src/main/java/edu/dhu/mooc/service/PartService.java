package edu.dhu.mooc.service;

import edu.dhu.mooc.entity.Part;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/12 15:11
 * @describe 处理和章节内容有关的业务
 *          主要还是用于数据有效性校验
 */
public interface PartService {


    boolean hasCoursePartIndex(String c_id,Integer p_index);

    boolean addNewPart(Part part);

    boolean deletePart(String p_id);
}
