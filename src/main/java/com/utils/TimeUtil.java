package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;


public class TimeUtil {

	public static final String F_YYYY_MM = "yyyy-MM";
	
	public static final String F_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String F_MM_DD = "MM-dd";
	public static final String F_HH_MM = "HH:mm";
	public static final String F_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String F_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

	/**
	 * 时间转字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	 public static String getWeekOfDate(long dt) {
	        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	        Calendar cal = Calendar.getInstance();
	        Date date= new Date(dt);
	        cal.setTime(date);
	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	        if (w < 0)
	            w = 0;
	        return weekDays[w];
	    }
	 
	 
	
	public static Date getDateByString(String date, String format) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			return new Date(0);
		}
	}
	
	 /**
     * 获取格式化的时间字符串
     *
     * @param date   时间
     * @param format 格式
     * @return
     */
    public static String getDateToString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
	
	 public static Date getAfterDayTime(Date d, int day) {
	        Calendar calendar = new GregorianCalendar();
	        calendar.setTime(d);
	        calendar.add(Calendar.DATE, day);
	        return calendar.getTime();
	    }
	 
	/**
     * 取日期范围内的日期(yyyy-MM-dd)数组
     * @param startDate
     * @param endDate
     * @param format
     * @return
     */
    public static List<Long> getDateListByRange1(String startDate, String endDate, String format) {
        List<Long> dates = new ArrayList<>();
        if (format == null) format = "yyyy-MM-dd";

        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(TimeUtil.getDateByString(startDate, format));
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(TimeUtil.getDateByString(endDate, format));

        while (!calendarStart.after(calendarEnd)) {
            dates.add(calendarStart.getTime().getTime());
            calendarStart.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dates;
    }
    

	/**
	 * 时间(long类型)转字符串
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String getString(long time, String format) {
		return getString(new Date(time), format);
	}

	/**
	 * 取指定时间前后的第N天（正数为后，负数为前）
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getAfterDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	 /**
     * 根据开始结束日期判断是否包含今天
     * @param begin
     * @param end
     * @return
     */
    public static boolean ifTodayIncluded(String begin,String end){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd");
            Date date=new Date();
            Date begindate=simpleDateFormat.parse(begin);
            Date enddate=simpleDateFormat.parse(end);
            if (date.before(enddate)||(simpleDateFormat.format(date)).equals(end))
                return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

	/**
	 * 取指定时间前后的第N个月（正数为后，负数为前）
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date getAfterMonths(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	/**
	 * 由字符串取日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date getDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date d = sdf.parse(date);
			return d;
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 由字符串取long类型时间
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static long getTime(String date, String format) {

		long time = 0L;
		try {
			time = getDate(date, format).getTime();
		} catch (Exception e) {

		}
		return time;
	}

	/**
	 * 指定时间内，取YYYY的列表
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> getYYYYList(Date start, Date end) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		int startY = calendar.get(Calendar.YEAR);
		calendar.setTime(end);
		int endY = calendar.get(Calendar.YEAR);

		List<String> list = new ArrayList<>();
		for (int y = startY; y <= endY; y++) {
			list.add(String.valueOf(y));
		}

		return list;
	}

	/**
	 * 指定的时间内取YYYYMM的列表
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> getYYYYMMList(Date start, Date end) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		endCalendar.set(Calendar.DAY_OF_MONTH, 1);
		List<String> list = new ArrayList();

		for (int i = 0; i < 10000; i++) {
			if (calendar.after(endCalendar)) {
				break;
			}
			int month = calendar.get(Calendar.MONTH) + 1;
			if (month > 9) {
				list.add(String.valueOf(calendar.get(Calendar.YEAR) + String.valueOf(month)));
			} else {
				list.add(String.valueOf(calendar.get(Calendar.YEAR) + "0" + String.valueOf(month)));
			}
			calendar.add(Calendar.MONTH, 1);
		}

		return list;
	}

	/**
	 * 指定的时间内取YYYYMMDD的列表
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> getYYYYMMDDList(Date start, Date end) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		List<String> list = new ArrayList<>();

		for (int i = 0; i < 10000; i++) {
			if (calendar.after(endCalendar)) {
				break;
			}
			list.add(sdf.format(calendar.getTime()));
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		return list;
	}

	public static String getStringByDate(long time, String format) {
		return getStringByDate(new Date(time), format);
	}

	/**
	 * 取今天结束时间(23:59:59)
	 * 
	 * @return
	 */
	public static long getTodayEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime().getTime() + 999L;
	}

	public static String getStringByDate(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String strDate = sdf.format(date);
			return strDate;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 日期增加天数，可以为负数
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * 日期增加月数，可以为负数
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addMonths(Date date, int months) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
//
//	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date d1 = sdf.parse("2012-01-03");
//		Date d2 = sdf.parse("2014-01-03");
//
//	}

	/**
	 * 取日期范围内的日期(yyyy-MM-dd)数组
	 * 
	 * @param startDate
	 * @param endDate
	 * @param format
	 * @return
	 */
	public static List<String> getDateListByRange(String startDate, String endDate, String format) {
		List<String> dates = new ArrayList<>();
		if (format == null)
			format = "yyyy-MM-dd";

		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(TimeUtil.getDate(startDate, format));
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.setTime(TimeUtil.getDate(endDate, format));

		while (!calendarStart.after(calendarEnd)) {
			dates.add(TimeUtil.getStringByDate(calendarStart.getTime(), "yyyy-MM-dd"));
			calendarStart.add(Calendar.DAY_OF_MONTH, 1);
		}

		return dates;

	}

	/**
	 * 取日期范围内的日期(yyyy-MM)数组
	 * 
	 * @param startDate
	 * @param endDate
	 * @param format
	 * @return
	 */
	public static List<String> getMonthListByRange(String startDate, String endDate, String format) {
		List<String> months = new ArrayList<>();
		if (format == null)
			format = "yyyy-MM-dd";

		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(TimeUtil.getDate(startDate, format));
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.setTime(TimeUtil.getDate(endDate, format));

		while (!calendarStart.after(calendarEnd)) {
			months.add(TimeUtil.getStringByDate(calendarStart.getTime(), "yyyy-MM"));
			calendarStart.add(Calendar.MONTH, 1);
		}

		return months;
	}
	
	
	
	/**
	 * 取日期范围内的日期数组
	 * 
	 * @param startDate
	 * @param endDate
	 * @param format
	 * @return
	 */
	public static List<String> getMonthListByRange2(String startDate, String endDate, String format, String type) {
		List<String> months = new ArrayList<>();
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(TimeUtil.getDate(startDate, format));
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.setTime(TimeUtil.getDate(endDate, format));

		while (!calendarStart.after(calendarEnd)) {
			months.add(TimeUtil.getStringByDate(calendarStart.getTime(), format));
			if(type.equals("day")){
				calendarStart.add(Calendar.DATE, 1);
			}else{
				calendarStart.add(Calendar.MARCH, 1);
			}
			
		}

		return months;
	}
	

	/**
	 * 取当前日期所在月份第一天
	 * 
	 * @param date
	 * @return
	 */
	public static long getFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime().getTime();
	}

	//取当月的第一天和最后一天
	public static Map<String,Object> getCurrentMonth(){
		Map<String, Object> map=new HashMap<String, Object>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());   
		  cal.set(Calendar.DAY_OF_MONTH, 1); 
		  map.put("startTime", new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
		  cal.roll(Calendar.DAY_OF_MONTH, -1);    
		  map.put("endTime", new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
		  return map;
	}
	/**
	 * 取前日期所在月的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static long getLastDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime().getTime() + 999L;
	}

	public static String getMonday() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		// model.put("toDay", df.format(cal.getTime()));

		// 获取本周一日期
		cal.set(Calendar.DAY_OF_WEEK+1, Calendar.MONDAY);
		return df.format(cal.getTime());

	}

	// 获取上周一日期
	public static String getLastMonday() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		cal.add(Calendar.WEEK_OF_MONTH, -1);
		cal.set(Calendar.DAY_OF_WEEK, 2);
		return df.format(cal.getTime());

	}

	// 获取上周天日期
	public static String getLast7() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		cal.set(Calendar.DAY_OF_WEEK, 1);
		return df.format(cal.getTime());

	}

	public static String getToday() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		return df.format(cal.getTime());

	}
	//取上个月的第一天和最后一天
	public static Map<String, Object> findLastMonth() {
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		  Calendar cal = Calendar.getInstance();
		  GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(new Date());

		  calendar.add(Calendar.MONTH, -1);
		  Date theDate = calendar.getTime();
		  gcLast.setTime(theDate);
		  gcLast.set(Calendar.DAY_OF_MONTH, 1);
		  String day_first_prevM = df.format(gcLast.getTime());
		  StringBuffer str = new StringBuffer().append(day_first_prevM);
		  day_first_prevM = str.toString();

		  calendar.add(cal.MONTH, 1);
		  calendar.set(cal.DATE, 1);
		  calendar.add(cal.DATE, -1);
		  String day_end_prevM = df.format(calendar.getTime());
		  StringBuffer endStr = new StringBuffer().append(day_end_prevM);
		  day_end_prevM = endStr.toString();

		  Map<String, Object> map = new HashMap<String, Object>();
		  map.put("prevMonthFD", day_first_prevM);
		  map.put("prevMonthPD", day_end_prevM);
		  return map;
		 }

	/**
	 * 判定是不是今天
	 * 
	 * @param time
	 *            时间毫秒串(<strong>注意:精确到毫秒</strong>)
	 * @return
	 * @author xuefei
	 */
	public static boolean isToday(final Long time) {
		if (null == time) {
			return false;
		}
		Calendar target = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		target.setTimeInMillis(time);
		if (target.get(Calendar.YEAR) == today.get(Calendar.YEAR) && target.get(Calendar.MONTH) == today.get(Calendar.MONTH)
				&& target.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getCurrentDay(String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		Date date=new Date();
		return sdf.format(date);
	}

	/**
	 * 时间范围校验
	 * 
	 * @param time
	 *            毫秒时间
	 * @param expired
	 *            过期时间
	 * @return
	 */
	public static boolean validTime(long time, long expired) {
		long diff = System.currentTimeMillis() - time;
		if (diff > expired || diff < -expired) {
			return false;
		}
		return true;
	}
	
	/**
	 * 根据查询类型返回时间范围
	 * @param request
	 * @param queryType
	 * @param format
	 * @return
	 */
	public static String transDate(HttpServletRequest request, String queryType, String format) {
		String startTime = request.getParameter("start_time");
		String endTime = request.getParameter("end_time");
		// 查询类型（今天，前一天，后一天，开服到今天）
		if (StringUtils.isNotBlank(format)) {
			if (StringUtils.isNotBlank(queryType)) {
				if ("today".equals(queryType)) {
					startTime = TimeUtil.getStringByDate(System.currentTimeMillis(), format);
					endTime = startTime;
				} else if ("totoday".equals(queryType)) {
					startTime = "";
					endTime = TimeUtil.getStringByDate(System.currentTimeMillis(), format);
				} else if ("pre".equals(queryType)) {
					Date date = null;
					if (StringUtils.isBlank(startTime)) {
						if("yyyy-MM-dd".equals(format)){
							date = TimeUtil.getAfterDays(new Date(), -1);
						}else if("yyyy-MM".equals(format)){
							date = TimeUtil.addMonths(new Date(), -1);
						}
						startTime = TimeUtil.getStringByDate(date.getTime(), format);
					} else {
						if("yyyy-MM-dd".equals(format)){
							date = TimeUtil.getAfterDays(TimeUtil.getDate(startTime, format), -1);
						}else if("yyyy-MM".equals(format)){
							date = TimeUtil.addMonths(TimeUtil.getDate(startTime, format), -1);
						}
						startTime = TimeUtil.getStringByDate(date.getTime(), format);
					}
					endTime = startTime;
				} else if ("next".equals(queryType)) {
					Date date = null;
					if (StringUtils.isBlank(startTime)) {
						if("yyyy-MM-dd".equals(format)){
							date = TimeUtil.getAfterDays(new Date(), 1);
						}else if("yyyy-MM".equals(format)){
							date = TimeUtil.addMonths(new Date(), 1);
						}
						endTime = TimeUtil.getStringByDate(date.getTime(), format);
					} else {
						if("yyyy-MM-dd".equals(format)){
							date = TimeUtil.getAfterDays(TimeUtil.getDate(endTime, format), 1);
						}else if("yyyy-MM".equals(format)){
							date = TimeUtil.addMonths(TimeUtil.getDate(endTime, format), 1);
						}
						endTime = TimeUtil.getStringByDate(date.getTime(), format);
					}
					startTime = endTime;
				} else if ("bz".equals(queryType)) {
					startTime = TimeUtil.getMonday();
					endTime = TimeUtil.getToday();
				} else if ("sz".equals(queryType)) {
					startTime = TimeUtil.getLastMonday();
					endTime = TimeUtil.getLast7();
				} else if ("7days".equals(queryType)) {
					startTime = TimeUtil.getStringByDate(TimeUtil.getAfterDays(TimeUtil.getDate(endTime, format), -7).getTime(), format);
					endTime = TimeUtil.getToday();
				} else if ("30days".equals(queryType)) {
					startTime = TimeUtil.getStringByDate(TimeUtil.getAfterDays(TimeUtil.getDate(endTime, format), -30).getTime(), format);
					endTime = TimeUtil.getToday();
				}else if("btn_lastMonth".equals(queryType)){
					Map<String,Object> map=TimeUtil.findLastMonth();
					startTime=map.get("prevMonthFD").toString();
					endTime=map.get("prevMonthPD").toString();
				}else if ("btn_currentMonth".equals(queryType)){
					Map<String, Object> map=TimeUtil.getCurrentMonth();
					startTime=map.get("startTime").toString();
					endTime=map.get("endTime").toString();
					endTime=TimeUtil.getString(System.currentTimeMillis(), format);
				}
			} else {
				// 默认查询前30天数据
				if (StringUtils.isBlank(startTime) || StringUtils.isBlank(endTime)) {
					Date date = new Date();
					endTime = TimeUtil.getStringByDate(date, format);
					startTime = TimeUtil.getStringByDate(TimeUtil.getAfterDays(TimeUtil.getDate(endTime, format), -7).getTime(), format);
				}
			}
		}
		return startTime + "," + endTime;
	}
	
    private static Map<String, String> getFirstday_Lastday_Month(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();
        
        //上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        day_first = str.toString();

        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
        day_last = endStr.toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }
    
    
    /**
     * 当月第一天
     * @return
     */
    private static String getFirstDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        return str.toString();

    }
    
    /**
     * 当月最后一天
     * @return
     */
    private static String getLastDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
        return str.toString();

    }
    
    

    
    /**
     * 指定的时间内取YYYYMM的列表
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> getYYYYMMList2(Date start, Date end) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        endCalendar.set(Calendar.DAY_OF_MONTH, 1);
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            if (calendar.after(endCalendar)) {
                break;
            }
            int month = calendar.get(Calendar.MONTH) + 1;
            if (month > 9) {
                list.add(String.valueOf(calendar.get(Calendar.YEAR) + "-" + String.valueOf(month)));
            } else {
                list.add(String.valueOf(calendar.get(Calendar.YEAR) + "-" + "0" + String.valueOf(month)));
            }
            calendar.add(Calendar.MONTH, 1);
        }

        return list;
    }
    
}
