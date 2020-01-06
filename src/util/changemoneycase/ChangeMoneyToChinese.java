package util.changemoneycase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 阿拉伯数字金钱转中文大写
 * 调用 changeToChinese(String money)  // 列:  ChangeMoneyToChinese.changeToChinese("50")
 * @author zt
 * @Date 2015年9月24日
 */
public class ChangeMoneyToChinese {
    private static String[] cCharcters = new String[] { "零", "壹", "贰", "叁",
	    "肆", "伍", "陆", "柒", "捌", "玖" };/* 数字对应的汉字大写 */
    private static String[] cnDws = new String[] { "", "拾", "佰", "仟" };/* 基本单位 */
    private static String[] cnDdws = new String[] { "", "万", "亿", "兆" };/* 大单位扩展 */
    private static String[] cnDecs = new String[] { "角", "分", "毫", "厘" };
    private static String cnInteger = "整";/* 整型金额处理后跟的字符 */
    private static String cnLast = "元";/* 数据处理后面 */
    private static Double maxNum = 999999999999999.9999;/* 定义一个最大处理数 */
    private static String bz = "负";
    private static String integerNum;/* 金额整数部分 */
    private static String decimalNum;/* 金额小数部分 */
    private static String[] parts = new String[2];/* 金额字符串分割部分 */
    private static String chineseStr = "";/* 接收转换后的中文大写字符串 */
    private static char str;

    public static String changeToChinese(String money) {
	str = money.charAt(0);
	if (str == '-') {
	    money = money.substring(1, money.length());/* 负数处理 */
	}
	/* 有三种其他情况：1，money="" 2.money=0 3,超出最大处理数据 */
	/* 将获取的字符串数值数据转换为double型便于与数值进行比较 */
	Double moneys = Double.parseDouble(money);
	if (money == "") {
	    chineseStr = "";
	    return chineseStr;
	} else if (moneys > maxNum) {
	    System.out.println("超出最大处理数，无法转换...");
	    chineseStr = "";
	    return chineseStr;
	} else if (moneys == 0) {
	    chineseStr = cCharcters[0] + cnLast + cnInteger;
	    return chineseStr;
	} else
	/* 数据正常情况的处理,首先对数据进行整型部分和小数部分安要求进行截取处理 */
	if (money.indexOf(".") == -1) {/* 字符串没有小数点的情况，整型 */
	    integerNum = money;/* 赋值整型 */
	    decimalNum = "";/* 无小数部分 */
	} else {/* 有小数的情况 */
	    parts = money.split("\\.");/* 注意java中分割符号的格式问题\\加分割符号 */
	    integerNum = parts[0];
	    decimalNum = parts[1];
	    if (decimalNum.length() > 4) {/* java中截取字符串需要对位数进行判断操作否则容易报数组下标越界问题 */
		decimalNum = parts[1].substring(0, 4);/* 只保留4位小数 */
	    } else {
		decimalNum = parts[1];
	    }
	}
	
	/*--------------------------*/
	/* 对整型部分处理的方法 */
	integerNum(integerNum, str);
	/* 对小数部分的处理方法 */
	decimalNum(decimalNum);
	/* 最后再对转换后的字符串进行判断 */

	// if(str=='-'){ chineseStr=bz+chineseStr; }

	lastStr(chineseStr, str);
	return chineseStr;

    }

    /* 对数据整型部分处理的方法 */
    public static String integerNum(String integerNum, char str) {
	if (Long.parseLong(integerNum, 10) > 0
		|| Long.parseLong(integerNum, 10) == 0) {// 获取整型部分转换，按10进制形式进行转换
	    int zeroCount = 0;
	    int intLen = integerNum.length();
	    for (int i = 0; i < intLen; i++) {
		String n = integerNum.substring(i, i + 1);
		int p = intLen - i - 1;
		int q = p / 4;
		int m = p % 4;
		if ("0".equals(n)) {
		    zeroCount++;
		} else {
		    if (zeroCount > 0) {
			chineseStr += cCharcters[0];
		    }
		    zeroCount = 0; // 归零
		    chineseStr += cCharcters[Integer.parseInt(n)] + cnDws[m];
		}
		if (m == 0 && zeroCount < 4) {
		    chineseStr += cnDdws[q];
		}
	    }
	    chineseStr += cnLast;
	    // 整型部分处理完毕
	}
	return chineseStr;
    }

    /* 对小数部分的处理方法 */
    public static String decimalNum(String decimalNum) {
	if (decimalNum != "") {// 小数部分
	    int decLen = decimalNum.length();
	    for (int i = 0; i < decLen; i++) {
		String n = decimalNum.substring(i, i + 1);
		/* 注意循环每次截取的时候需要往后一位进行截取， 向右边移动一位 */
		if (n != "0") {
		    chineseStr += cCharcters[Integer.parseInt(n)] + cnDecs[i];
		}
	    }
	}
	return chineseStr;
    }

    /* 最后再对转换后的字符串进行判断处理 */
    public static String lastStr(String strr, char str) {

	if (chineseStr == "") {/* 0数据判断 */
	    chineseStr += cCharcters[0] + cnLast + cnInteger;
	} else if (decimalNum == "") {/* 整型判断 */
	    chineseStr += cnInteger;
	}

	if (str == '-') {/* 负数最后的处理   */
	    chineseStr = bz + chineseStr;
	}
	return chineseStr;
    }
}
