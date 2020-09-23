package com.tl.cmsservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.commonutils.R;
import com.tl.cmsservice.entity.CrmBanner;
import com.tl.cmsservice.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author tl
 * @since 2020-09-21
 */
@RestController
@RequestMapping("/educms/banneradmin")
@CrossOrigin
public class BannerAdminController {

    @Autowired
    private CrmBannerService bannerService;

    @GetMapping("pageBanner/{page}/{limit}")
    public R pageBanner(@PathVariable long page, @PathVariable long limit){

        Page<CrmBanner> pageBanner = new Page<>(page,limit);
        IPage<CrmBanner> bannerIPage = bannerService.page(pageBanner, null);


        return  R.ok().data("items",bannerIPage.getRecords()).data("total",bannerIPage.getTotal());
    }


    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        CrmBanner banner = bannerService.getById(id);
        return R.ok().data("item", banner);
    }

    @PostMapping("addBanner")
    public R save(@RequestBody CrmBanner banner) {
        bannerService.save(banner);
        return R.ok();
    }

    @PutMapping("update")
    public R updateById(@RequestBody CrmBanner banner) {
        bannerService.updateById(banner);
        return R.ok();
    }


    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        bannerService.removeById(id);
        return R.ok();
    }
}



