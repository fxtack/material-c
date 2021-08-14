package com.fxtack.materialc;

import cn.hutool.core.date.DateUtil;
import com.fxtack.materialc.config.DeleteThreadConfig;
import com.fxtack.materialc.entity.InviteCode;
import com.fxtack.materialc.entity.LoginUser;
import com.fxtack.materialc.entity.Material;
import com.fxtack.materialc.entity.VirtualFolder;
import com.fxtack.materialc.entity.format.FormatDeleteMessage;
import com.fxtack.materialc.mapper.MaterialMapper;
import com.fxtack.materialc.service.*;
import com.fxtack.materialc.thread.DeleteThread;
import com.fxtack.materialc.entity.DeleteMessage;
import com.fxtack.materialc.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试类, 集合操作请使用 stream 接口与 Lambda 表达式
 *
 * @author fxtack
 */
@SpringBootTest
class MaterialCApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    MaterialService materialService;

    @Autowired
    VirtualService virtualService;

    @Autowired
    StatisticsInfoService statisticsInfoService;

    @Autowired
    LoginUserService loginUserService;

    @Autowired
    TaskService taskService;

    @Test
    void contextLoads() throws SQLException {
        List<Material> list = materialService.findByPathId(1);
        list.stream().forEach(material -> {
            System.out.println(material);
        });
    }

    @Test
    void test() {
        virtualService.getAll().stream().forEach(virtualFolder -> {
            System.out.println(virtualFolder);
        });
    }

    @Test
    void test2() {
        materialService.updateRemark(248,"更新测试");
    }

    @Test
    void test3() {
        List<Material> list = materialService.findByPathId(1);
        list.stream().forEach(material -> {System.out.println(material.getPictureSize());});
        System.out.println("---------------------------------------------");
        list.sort(Util::compareBySize);
        list.stream().forEach(material -> {System.out.println(material.getPictureSize());});
    }

    @Test
    void test4() {
        List<Material> list =  materialService.search(1,"A");
        list.stream().forEach(e->System.out.println(e.getPictureName()));
    }

    @Test
    void test5() {
        List<Material> list = materialService.findAllFavour();
        list.stream().forEach(e->System.out.println(e));
    }

    @Test
    void test6() {
        List<Material> list = materialService.searchNameFromFavour("2");
        list.stream().forEach(e->System.out.println(e));
    }

    @Test
    void test7() {
        List<Material> list = materialService.findAllFavour();
        list.stream().filter(e->{
            if(e!=null) {
                return e.getIsDelete() != null && e.getIsDelete() != 1;
            }else {
                return false;
            }
        })
                .collect(Collectors.toList()).stream().forEach(e->System.out.println(e));
    }

    @Test
    void test8() {
//        List<StatisticsInfo> list = statisticsInfoMapper.selectAll();
//        list.stream().forEach(e->System.out.println(e));
        System.out.println(statisticsInfoService.findSumSize());
    }

    @Test
    void test9() {
        materialService.findAllFavour().stream().forEach(e->System.out.println(e));
    }

    @Test
    void test10() {
        System.out.println(loginUserService.findById(1));
    }

    @Test
    void test11() {
        taskService.findAll().stream().forEach(e->System.out.println(e));
    }

    @Test
    void test12() {
        List<String> list = new ArrayList<>();
        String a = "123;abc;home;144|";
        Arrays.asList(a.split(";")).stream().forEach(e->System.out.println(e));
    }

    @Test
    void test13() {
        Thread t1 = new Thread(()->{
            for(int a = 0 ; a < 100 ; a++) {
                System.out.println("1024");
            }
        });
        Thread t2 = new Thread(()->{
            for(int a = 0 ; a < 10 ; a++) {
                System.out.println("2048");
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    void test14() {
        Thread t = new Thread(()->{
            while(true){
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                File file = new File("C:/Users/DELL/Pictures/新桌面.png");
                if(file.exists()) {
                    file.delete();
                    System.out.println("删除文件");
                }else {
                    System.out.println("已完成删除，申请中断线程");
                    Thread.interrupted();
                }
            }
        });
        t.setDaemon(true);
        t.start();
        while(true){}
    }

    @Test
    void test15() {
        String userPath = System.getProperties().getProperty("user.home") + "/material";
        System.out.println(userPath+ materialService.findById(459).getPicturePath());
    }

    @Test
    void test16(){
        Date data = new Date(),data2;
        System.out.println(data);
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH, 1);
//        data2 = cal.getTime();
        System.out.println(data+"\n");
//        System.out.println(data.before(data2));
    }

    @Autowired
    DeleteThreadConfig deleteThreadConfig;

    @Test
    void test17() {
        System.out.println(deleteThreadConfig.getMinute());
    }

    @Autowired
    DeleteThread thread;

    @Test
    void test18() {

        List<File> list = Arrays.asList(
                new File("E:/.test/0.txt"),
                new File("E:/.test/1.txt"),
                new File("E:/.test/2.txt"),
                new File("E:/.test/3.txt"),
                new File("E:/.test/4.txt"),
                new File("E:/.test/5.txt"),
                new File("E:/.test/6.txt"),
                new File("E:/.test/7.txt"),
                new File("E:/.test/8.txt")
        );
        thread.start();
        for(int i = 0 ; i < 9 ; i++) {
            thread.putDeleteMessage(new DeleteMessage(list.get(i).getAbsolutePath()));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(true);
    }

    @Test
    void test19() {
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test20() throws ParseException {
        Date now = new Date();
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy HH:mm");// 02/24/2021 01:10
        System.out.println(f.parse("02/24/2021 01:10") instanceof Date);
    }

    @Test
    void test21() {
        Arrays.asList("abx.123a.a.dw.".split("\\.")).stream().forEach(e->System.out.println(e));
    }

    @Test
    void test22() {
        taskService.countTag().stream().forEach(e->System.out.println(e));
    }

    @Test
    void test23() {
        VirtualFolder virtualFolder = new VirtualFolder();
        virtualFolder.setFolderName("1");
        virtualFolder.setId(null);
        virtualFolder.setFolderRemark("r");
        virtualFolder.setFolderCreateDate(new Date());
        virtualFolder.setFolderAbsolute("asd");
        virtualFolder.setFolderFileSize("44");
        virtualService.save(virtualFolder);
        System.out.println(virtualFolder.getId());
    }

    @Test
    void test24() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
    }

    @Test
    void test25() {
        System.out.println(virtualService.findById(1));
    }

    @Test
    void test26() {
        Map<Integer, String> map = virtualService.findSerialPathInfoByPathId(3);
        map.forEach((k, v)-> {
            System.out.println(k+":"+v);
        });
    }

    @Test
    void test27() {
        System.out.println(materialService.findByPathId(2).isEmpty());
    }

    @Test
    void test28() {
        VirtualFolder virtualFolder = virtualService.findById(2);
        virtualFolder.setInnerFolderId(
                Arrays.asList(virtualFolder.getInnerFolderId().split(";"))
                        .stream()
                        .filter(e->Integer.valueOf(e)!=14)
                        .reduce("" ,(a,c)->a+c+";")
        );
        System.out.println(virtualFolder.getInnerFolderId());
    }

    @Test
    void test29() {
        System.out.println(virtualService.findById(25).getInnerFolderId());
    }

    @Test
    void test30() {
        Integer[] list = {475, 476};
        materialService.updateVirtualPathId(list, 3);
    }

    @Autowired
    MaterialMapper materialMapper;
    @Test
    void test31() {
        Material m1 = new Material(),m2 = new Material();
        m1.setVirtualPathId(0);
        m1.setIsDelete(0);
        m1.setIsFavour(0);
        m2.setVirtualPathId(0);
        m2.setIsDelete(0);
        m2.setIsFavour(0);
        List<Material> list = Arrays.asList(m1, m2);
        materialMapper.multipleInsert(list);
    }

    @Test
    void test32() {
        materialMapper.multipleSelectByPrimaryKey(new Integer[]{new Integer(474), new Integer(476)})
                .stream()
                .forEach(e->System.out.println(e));
    }

    @Test
    void test33() {
        materialMapper.multipleUpdateFavourByPrimaryKey(new Integer[]{new Integer(474), new Integer(476)}, 1);
    }

    @Test
    void test34() {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(1);
        loginUser.setUserAutograph("Hello");
        loginUserService.updateByIdSelective(loginUser);
        System.out.println(loginUserService.findById(1));
    }

    @Test
    void test35() {
        for(int i = 0 ; i < 100 ; i++) {
            System.out.println(new Random().nextInt(1000));
        }
    }

    @Test
    void test36() {
        Date date = DateUtil.date();
        System.out.println(date.toString());
    }

    @Test
    void test37() {
        loginUserService.findAll().stream().forEach(s->System.out.println(s));
    }

    @Autowired
    InviteCodeService inviteCodeService;

    @Test
    void test38() {
        InviteCode inviteCode = new InviteCode();
        inviteCode.setInviteCreateDate(DateUtil.date().toString());
        inviteCode.setInviteEndDate(DateUtil.date().toString());
        inviteCode.setInviteValue(((int)(Math.random()*1000000))+"");
        inviteCode.setInviteRemark("测试验证码");
        inviteCodeService.save(inviteCode);
        inviteCodeService.findAll().stream().forEach(e-> System.out.println(e));
    }

    @Test
    void test39() {
        System.out.println(inviteCodeService.findByValue("5659as5").getId());
    }

    @Test
    void test40() throws ParseException {
        Date now = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yy-MM-dd HH:mm:ss");// 02/24/2021 01:10
        System.out.println(f.parse("2021-03-08 22:00:40").before(DateUtil.date()));
    }

    @Autowired
    DeleteMessageService deleteMessageService;

    @Test
    void test41() {
        List<FormatDeleteMessage> list = Arrays.asList(
                        new FormatDeleteMessage(null, "asd", "2022-2-2 2:22:22", "2022-2-2 2:22:22"),
                        new FormatDeleteMessage(null, "123", "2022-2-2 2:22:22", "2022-2-2 2:22:22"),
                        new FormatDeleteMessage(null, "zxc", "2022-2-2 2:22:22", "2022-2-2 2:22:22"),
                        new FormatDeleteMessage(null, "qwe", "2022-2-2 2:22:22", "2022-2-2 2:22:22")
        );
        FormatDeleteMessage.toDeleteMessage(list).stream().forEach(e->System.out.println(e));
    }

    @Test
    void test45() {
        List<FormatDeleteMessage> list = Arrays.asList(
                new FormatDeleteMessage(null, "asd", "2022-2-2 2:22:22", "2022-2-2 2:22:22"),
                new FormatDeleteMessage(null, "123", "2022-2-2 2:22:22", "2022-2-2 2:22:22"),
                new FormatDeleteMessage(null, "zxc", "2022-2-2 2:22:22", "2022-2-2 2:22:22"),
                new FormatDeleteMessage(null, "qwe", "2022-2-2 2:22:22", "2022-2-2 2:22:22")
        );
        List<DeleteMessage> list1 = FormatDeleteMessage.toDeleteMessage(list);
        deleteMessageService.multipleInsert(FormatDeleteMessage.toFormatDeleteMessage(list1));
    }

    @Test
    void test46() {
        File file = new File("C:\\Users\\DELL/material/upload/2021/3/final20210313141613301.png");
        file.delete();
    }
}
