package com.dingjiajia.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.mall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 15:01:41
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

