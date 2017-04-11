# usefull

##常用算法

>cn.myroute.algo.MergeTest  归并排序  N * log(2,n)
>
>cn.myroute.algo.QuickTest  快排  N * log(2,n)
>
>cn.myroute.algo.HeapSort  堆排  N * log(2,n)
>



##神代码

###1、交换

>利用异或 原理， A ^ B ^ A = B , A ^ B ^ A ^ B = 0  ，特点是不需要新建变量即可实现交换

	void swap(int[] dat ,int i,int j){
		dat[i]=dat[i] ^ dat[j];
		dat[j]=dat[i] ^ dat[j];
		dat[i]=dat[i] ^ dat[j];
	}
	
>
>另外，在storm的acker原理中使用的也是这个原理，每个bolt在处理task前，生成一个id，处理完后再把这个id反馈给acker，acker通过多值异或的结果是否为0，来判断任务是否完成。
>	
	
###2、base64的数字串实现千分比切量

>利用字符串有多少个不同字符构成，构成多少进制的原来，来试下千分比，如下


	/**
     * utdid灰度采样策略
     *
     * @param utdid   utdid 已经经过base64编码，形如V6MMBtXtr+gDAFJRSvAH9GaK
     * @param percent 单位：‰ 千分之一。 例如 输入300，代表千分之三百。输入范围0-1000
     * @return 是否选中该utdid。 选中的综合概率是percent/1000
     */
    public static boolean sampleDevice(String utdid, int percent) {
        String BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        if(utdid==null||utdid.length()<4||percent<=0){
            return false;
        }
        if(percent >= 1000){
            return true;
        }
        int len = utdid.length();
        int r4 = BASE64.indexOf(utdid.charAt(len - 4));
        int r3 = BASE64.indexOf(utdid.charAt(len - 3));
        int r2 = BASE64.indexOf(utdid.charAt(len - 2));
        int res = r4 * 4096 + r3 * 64 + r2;
        int Th = 262144 * percent / 1000;
        return res < Th;
    }
    
>
>扩展：千分比，百分比，32位，128位 等等。


###3、 >> <<  >>> 左移1位是×2，右移1位是÷ 2


    

