package com.company.thread;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/8
 */
class Train extends Thread{
    static int count = 100;
    String lock = "lock";
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (lock) {
                lock = "ss";
                if (count > 0) {
                    System.out.println(this.getName() + "卖火车票" + count--);
                }
            }
        }
        System.out.println(count);
    }
}
