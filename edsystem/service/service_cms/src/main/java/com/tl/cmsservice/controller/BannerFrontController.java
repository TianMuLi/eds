package com.tl.cmsservice.controller;

import com.tl.commonutils.R;
import com.tl.cmsservice.entity.CrmBanner;
import com.tl.cmsservice.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/educms/crm-bannerfront")
@CrossOrigin
public class BannerFrontController {
    @Autowired
    private CrmBannerService bannerService;

    @GetMapping("getAllBanner")
    public R getAllBanner(){
        List<CrmBanner> list = bannerService.selectAllBanner();
        return R.ok().data("list",list);
    }

}
