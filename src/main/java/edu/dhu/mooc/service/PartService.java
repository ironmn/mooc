package edu.dhu.mooc.service;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/12 15:11
 * @describe 处理和章节内容有关的业务
 *          主要还是用于数据有效性校验
 */
public interface PartService {


    boolean hasCoursePartIndex(String c_id,Integer p_index);
}
