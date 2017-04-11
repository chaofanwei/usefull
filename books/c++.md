###c编译
静态函数库 .a  
动态函数库 .so  

###编译入门
.o 为编译后生成的object文件 ，链接之后生成可执行文件，默认a.out
gcc -c main.c (生成main.o)  
gcc -o main main.c  
gcc -o main mian.o  
gcc -o main main.o test.o (把main.o和test.o链接成main)  
####静态函数库
ar -rc test.a test.o (由test.o生成test.a 静态函数库)  
gcc -o main main.o ./test.a  把静态库链接（加入）到mian里面 //注：./ 是给出了test.a的路径  

####动态函数库
`gcc -fPIC -c test.c `  
生成test.o文件，PIC”命令行标记告诉GCC产生的代码不要包含对函数和变量具体内存位置的引用  
    
    gcc -shared -o libtest.so test.o  
生成动态库libtest.so  

    gcc -o main -ltest -L . main.c  
“-ltest”标记来告诉GCC在连接阶段引用共享函数库libtest.so。“-L.”标记告诉GCC函数库可能位于当前目录中，否则GNU的连接器会查找标准系统函数库目录，在本例的情况下，就找不到可用的函数库了。  


###库搜索路径
/etc/ld.so.conf 相当于path  
export LD_LIBRARY_PATH=\`pwd\`  临时环境变量  

###查询命令依赖的库  
ldd main

    [root@10.10.72.63]$ ldd main  
        linux-vdso.so.1 =>  (0x00007fff37137000)  
        libtest.so => not found  
        libc.so.6 => /lib64/libc.so.6 (0x0000003e08800000)  
        /lib64/ld-linux-x86-64.so.2 (0x0000003e08400000)
    [root@10.10.72.63]$ export LD_LIBRARY_PATH=`pwd`  
    [root@10.10.72.63]$ ldd main
        linux-vdso.so.1 =>  (0x00007fff37137000)
        libtest.so => /home/weichaofan/c++/test3/libtest.so (0x00002ba082f33000)
        libc.so.6 => /lib64/libc.so.6 (0x0000003e08800000)
        /lib64/ld-linux-x86-64.so.2 (0x0000003e08400000)