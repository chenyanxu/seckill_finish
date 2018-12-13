package org.seckill.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author yangxin
 * @version 1.00
 * @time 2018/12/6  12:05
 */
public class Test {

    public static void main(String[] args){
        System.out.printf(ReverseSentence("I am a student."));
    }
    public static String ReverseSentence(String str) {
        if(str=="") return  " ";
        ArrayList<String> list=new ArrayList<>();
        String []strings=str.split(" ");
        String new_str="";
        for(int i=strings.length-1;i>=0;i--){
            new_str+=strings[i];
            if(i!=0)
                new_str+=" ";
        }


        return new_str;
    }

    public static String reverse(String str,int start,int end){
        String s=str.substring(0,start);
        char []str1=new char[end-start+1];
        int j=0;
        for(int i=end-1;i>=start;i--,j++){
            str1[j]=str.charAt(i);
        }
        String s1=new String(str1);
        return s+s1+str.substring(end,str.length());
    }
    /**
    * ����ʵ��˵��:
     * �ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨��
    * @author      yangxin
    * @date        2018/12/10 16:24
    */
    public static String LeftRotateString(String str,int n) {
        if(n>str.length()||n<0){
            return "";
        }
        String rotate=str.substring(0,n);
        String end=str.substring(n);
        return end+rotate;
    }
    
    /**
    * ����ʵ��˵�� ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
     * ����ж�����ֵĺ͵���S������������ĳ˻���С��
    * @author      yangxin
     * @param
    * @return      
    * @exception   
    * @date        2018/12/6 14:50
    */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(array.length<1||sum==0||array==null)
            return list;
        int start=0;
        int end=array.length-1;
        while(start<end){
            int newSum=array[start]+array[end];
            if(newSum==sum){
                list.add(array[start]);
                list.add(array[end]);
                return list;
            }
            else if(newSum>sum){
                start++;
            }else
                end--;
        }
        return list;
    }




    /**����һ��
     * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
     *
     * @param
     * @return
     * @throws
     * @author yangxin
     * @date 2018/12/6 13:14
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (sum < 3)
            return lists;
        int mid = (1 + sum) / 2;
        for (int i = 2; i <= mid; i++) {
            if(FindNumber(sum, i).size()!=0)
                if(!lists.contains(FindNumber(sum, i)))
                    lists.add(FindNumber(sum, i));
        }
        /*
        ����
         */
        Collections.sort(lists, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0)>o2.get(0))
                    return 1;
                if(o1.get(0)<o2.get(0))
                    return -1;
                return 0;
            }
        });

        return lists;
    }
    /**
    * FindContinuousSequence�ĵ��ú�����ʵ���ҳ�һ����ڵ�����
    * @author      yangxin
     * @param
    * @return
    * @exception
    * @date        2018/12/6 14:20
    */
    public static ArrayList<Integer> FindNumber(int sum, int i) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (i % 2 == 0) {
            if (sum % i == i / 2 && (sum / i - i / 2 + 1) >= 0) {
                int j = (sum / i - i / 2 + 1);
                if(j==0)
                    j++;
                for (; j <= (sum / i + i / 2); j++)
                    list.add(j);
            }
        } else {
            if (sum % i == 0 && (sum / i - i / 2) >= 0) {
                int j = (sum / i - i / 2 );
                if(j==0)
                    j++;
                for (; j <= (sum / i + i / 2); j++) {
                    list.add(j);
                }
            }
        }
        return list;
    }

    /**
    * ��������������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
    * @author      yangxin
     * @param
    * @return
    * @exception
    * @date        2018/12/6 14:21
    */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
        if(sum<3)
            return lists;
        int start=1;
        int end=2;
        int middle=(1+sum)/2;
        int newSum=start+end;
        while(start<middle){
            if(newSum==sum){
                if(addToList(start,end).size()>1)
                lists.add(addToList(start,end));
            }

            while (newSum>sum&&start<end){
                newSum-=start;
                start++;
                if(newSum==sum){
                    if(addToList(start,end).size()>1)
                    lists.add(addToList(start,end));
                }
            }
            end++;
            newSum+=end;

        }
        return lists;
    }

    public static ArrayList<Integer> addToList(int start,int end){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=start;i<=end;i++)
            list.add(i);
        return list;
    }




}
