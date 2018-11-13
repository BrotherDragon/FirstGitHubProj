import java.util.Scanner;

/*
 *  吃貨聯盟訂餐系統
 * @author  Yzj
 *
 * */
public class EatingLeague {
    public static void main(String[] args) {
     // 數據主題，一組訂單信息
        String [] names = new String[11];     //訂餐人
        String [] dishMegs = new String[11];   //所定餐品信息
        int [] times = new int [11] ;    //送餐時間
        String [] addresses = new String[11]; //送餐地址
        int [] states = new int [11]; //訂單狀態 0：已預訂 1：已完成
        double [] sumPrices = new double[11]; //總金額

        //初始化2條訂單嘻嘻
        names[0]="醬爆";
        dishMegs[0]="    佛跳墻 1份";
        times[0]= 12;
        addresses[0]="錦綉長江209號";
        states[0]= 0;
        sumPrices[0]=9999.9; //未滿50元+送餐費

        names[1]="牛屁王";
        dishMegs[1]="香酥鷄柳 2份";
        times[1]= 12;
        addresses[1]="濱江大道101號";
        states[1]=1;
        sumPrices[1]=44.4;

        //數據主題：一組餐品信息
        String [] disNames = {"黃瓜燒肉","番茄鷄蛋","時令蔬菜","魚香肉絲","香酥鷄柳","土豆牛腩","豬肉火鍋","黑椒牛排","宮保鷄丁","佛跳墻"};
        double [] prices = {15.0,13.0,10.0,13.5,22.2,29.8,88.8,47.5,34.5,9999.9};  //餐品單價
        int [] pricesNums = new int [11];  //點讚數

        /*    循環(do-while);
        *     循環操作
        *     顯示主菜單
        *     提示用戶輸入功能編號，并執行相應功能
        *     提示輸入0返回
        * */
        Scanner input = new Scanner (System.in);
        int num = -1;     //記録用戶輸入的數字
        do{
            //循環操作
            // 顯示主菜單
            System.out.println ("***********************");
            System.out.println ("1.我要訂餐");
            System.out.println ("2.查看餐帶");
            System.out.println ("3.簽收訂單");
            System.out.println ("4.刪除訂單");
            System.out.println ("5.我要點讚");
            System.out.println ("6.退出系統");
            System.out.println ("***********************");
            //提示用戶輸入功能編號，並且執行相應功能
            System.out.print ("請選擇：");
            int choose = input.nextInt ();

            boolean isAdd = false; // true：找到一個為空的位置，可以插入  false：沒有找到
            switch (choose){
                case 1:
                //1.我要訂餐
                    System.out.println ("**********我要訂餐**********");
                //1.1查找要插入的位置
                    for(int i=0;i<names.length;i++){
                        //如果找到空的位置，記録下來
                        if(names[i]==null){
                            isAdd = true;  // 已經找到一個為空的位置
                            //執行插入操作
                            //a.顯示所有可供選擇的餐品信息
                            System.out.println ("序號  餐品名 \t  單價 \t點讚數");
                            for(int j=0;j<disNames.length;j++){
                                String price = prices[j]+"元";
                                String praise = pricesNums[j]+"贊";
                                System.out.println ((j+1)+"\t"+disNames[j]+"\t  "+price+"\t "+praise);
                            }
                            // 輸入所選餐品編號以及分數
                            System.out.print ("請選擇所定餐品的序號：");
                            int chooseDish = input.nextInt ();
                            System.out.print ("請選擇所定份數");
                            int number = input.nextInt ();
                            String dishMeg = disNames[chooseDish-1]+" "+number+"份";

                            // b.請輸入訂餐人的姓名
                            System.out.print ("請輸入訂餐人的姓名");
                            String name = input.next ();

                            // c. 輸入送餐時間
                            System.out.print ("請輸入送餐時間(10~20點整點送餐)");
                                int time = input.nextInt ();
                            //如果輸入有誤,重複輸入
                            while(time<10||time>20){
                                System.out.println ("對不起，您的輸入有誤，請輸入10~20之間的整數：");
                                time = input.nextInt ();
                            }
                            // d.輸入送餐地址
                            System.out.print ("請輸入送餐地址：");
                            String address = input.next ();

                            // e.計算殘廢
                            double sumPrice = prices[chooseDish-1]*number;
                            // 送餐費，當餐費達到50元時，免6元送餐費
                            double deliCharge = sumPrice>=50?0.0:6.0;

                            //顯示訂單信息
                            System.out.println ("訂餐成功！");
                            System.out.println ("您訂的是："+dishMeg);
                            System.out.println ("訂餐人："+name);
                            System.out.println ("送餐時間："+time+"點");
                            System.out.println ("送餐地址："+address);
                            System.out.println ("餐費："+sumPrice+",送餐費："+deliCharge+"元");
                            System.out.println ("總金額："+(sumPrice+deliCharge)+"元");

                            //保存數據
                            names[i]= name;
                            dishMegs[i]= dishMeg;
                            times[i]= time;
                            addresses[i]= address;
                            sumPrices[i]= sumPrice+deliCharge;

                            break;
                        }else{

                        }
                    }
                    //如果沒有找到空的位置，則提示信息
                    if(!isAdd){
                        System.out.println ("對不起，您的餐袋已滿！");
                    }
                break;
                case 2:
                //2.查看餐帶
                    System.out.println ("*******查看餐袋*******");
                    System.out.println ("序號\t訂餐人\t    所定餐品信息\t\t送餐時間\t 送餐地址\t\t總金額\t狀態 ");
                    //遍歷數組
                    for(int i=0;i<names.length;i++){
                        if(names[i]!=null){
                            String time = times[i]+ "點";
                            String sumPrice = sumPrices[i] + "元";
                            String state = states[i]==0?"已預定":"已完成";
                            System.out.println ((i+1)+"\t"+names[i]+"\t\t"+dishMegs[i]+"\t\t"+time+"\t\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
                        }
                    }
                break ;
                case 3:
                //3.簽收訂單
                    System.out.println ("請輸入要簽收的清單序號：");
                    int signOrderId = input.nextInt ();
                    boolean isFind = false; //記録是否找到了這條訂單 true：已找到  false：沒有找到
                    // 查找這條訂單(循環遍歷)
                    for(int i=0;i<names.length;i++){
                        //1.找到，狀態已完成：提示不能再次簽收
                        //2.找到，狀態已預訂，可以簽收
                        if(names[i]!=null && states[i]==1 && signOrderId==i+1){
                            System.out.println ("對不起,您選擇的訂單已經完成簽收,不能再次簽收！");
                            isFind = true;
                            break;
                        }else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
                            states[i]=1; //狀態值改為已完成狀態
                            System.out.println ("訂單簽收成功！");
                            isFind = true;
                            break;
                        }
                    }
                    //條件判斷，如果沒有找到這條訂單，才去提示沒有找到
                    if(!isFind){
                        System.out.println ("對不起，此訂單不存在！");
                    }
                    // 3. 沒找到，提示信息沒有找到
                break;
                case 4:
                //4.刪除訂單
                //1.輸入要刪除的訂單(從1開始)
                    System.out.println ("********刪除訂單********");
                    System.out.println ("請輸入要刪除的訂單序號：");
                    int delId = input.nextInt ();
                    int delIndex = -1;     //刪除訂單的下標
                    boolean isDelFind = false; //記録是否找到此條訂單 true：找到 false：沒找到
                //2.循環查找這條訂單
                for(int i=0;i<names.length;i++){
                    //找到此訂單，已簽收：執行刪除操作(先記録要刪除的訂單序號)
                    //找到此訂單，且未簽收：提示信息
                    if(names[i]!=null && states[i]==1 && delId==i+1){
                        delIndex = i;
                        isDelFind = true;
                        break;
                    }else if(names[i]!=null && states[i]==0 && delId==i+1){
                        System.out.println ("您選擇的訂單未簽收，不能刪除！");
                        isDelFind = true;
                        break;
                    }
                }
                //未找到此訂單：提示信息
                    if(!isDelFind){
                        System.out.println ("對不起，此條訂單不存在！");
                }
                // 執行刪除操作
                if(delIndex!=-1){
                    //刪除操作（循環移位）
                    //從要刪除的元素後面一個開始，到數組的最後一個元素依次向前移動一位
                    for(int i=delIndex+1;i<names.length;i++){
                        names[i-1] = names [i];
                        dishMegs[i-1] = dishMegs [i];
                        times [i-1] = times [i];
                        addresses [i-1] = addresses [i];
                        states [i-1] = states [i];
                    }
                  //最後一位清空
                    names[names.length-1] = null;
                    dishMegs[names.length-1] = null;
                    times[names.length-1] = 0;
                    addresses[names.length-1] = null;
                    states[names.length-1] = 0;

                    System.out.println ("訂單刪除成功！");
                }
                break ;
                case 5:
                //5.我要點讚
                    System.out.println ("*******窩要點讚*******");
                //5.1顯示提供點讚的餐品列表
                    System.out.println ("序號 餐品名 \t單價 \t點讚數");
                    for(int j=0;j<disNames.length;j++){
                        String price = prices[j]+"元";
                        String praise = pricesNums[j]+"贊";
                        System.out.println ((j+1)+"\t"+disNames[j]+"\t"+price+"\t"+praise);
                    }
                //5.2 輸入要點讚的餐品序號
                    System.out.println ("請輸入要點讚的餐品序號：");
                    int dishId = input.nextInt ();
                //5.3 該序號的餐品點讚數+1
                    pricesNums[dishId-1]++;
                //5.4 顯示
                    System.out.println ("點讚成功");
                    System.out.println (disNames[dishId-1]+" "+pricesNums[dishId-1]+"贊");

                break ;
                case 6:
                //6.退出系統
                break ;
                    default:
                    break;
            }
            //當用戶輸入的功能編號為1~5之外的數字時,退出循環，否則將會提示輸入0返回
            if(choose<1||choose>5){
                break;
            }else{
                System.out.print ("輸入0返回：");
                num = input.nextInt ();
            }
        }while(num==0);
        System.out.println ("謝謝使用，歡迎下次光臨");
    }
}
