package cn.example.ip_spring_boot_starter.service;

import cn.example.ip_spring_boot_starter.ipProperties.Ipproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ipCountService {
    private Map<String,Integer> ipCountMap=new HashMap<String, Integer>();
    //当前request对象的注入工作由使用当前starter的工程提供自动装配
    @Autowired
    private HttpServletRequest request;
    public void count(){
        //每当调用当前操作，旧纪录当前访问ip，然后累加访问次数
//        1、获取当前操作的ip
        String ip=request.getRemoteAddr();
        System.out.println("------------------------"+ip);
//        2、根据当前ip地址从map取值递增
        Integer count=ipCountMap.get(ip);
        if (count==null){
            ipCountMap.put(ip,1);
        }else{
            ipCountMap.put(ip,count+1);
        }
    }
    @Autowired
    private Ipproperties ipproperties;
//    @Scheduled(cron = "0/${tools.ip.cy} * * * * ?")
    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print(){
        System.out.println();
        if (ipproperties.getModel().equals(Ipproperties.LogModel.DETAIL.getValue())){
            System.out.println("-----------IP访问监控----------");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s  |%5d  |",key,value));
            }
            System.out.println("+--------------------+-------+");
        }else if (ipproperties.getModel().equals(Ipproperties.LogModel.SIMPLE.getValue())){
            System.out.println("-------IP访问监控--------");
            System.out.println("+-----ip-address-----+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                System.out.println(String.format("|%18s  |",key));
            }
            System.out.println("+--------------------+");
        }



        if (ipproperties.getReset()){
            ipCountMap.clear();
        }
    }


}
