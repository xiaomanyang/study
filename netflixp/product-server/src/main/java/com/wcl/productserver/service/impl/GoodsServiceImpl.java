package com.wcl.productserver.service.impl;

import com.wcl.entity.Goods;
import com.wcl.productserver.mapper.GoodsMapper;
import com.wcl.productserver.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wcl
 * @since 2021-04-23
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
