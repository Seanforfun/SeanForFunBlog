package ca.seanforfun.blog.model.entity.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 20, 2018 8:30:01 PM
 * @version 1.0
 */
public class Badge {
	public static final Integer COLOR_BLUE = 1;
	public static final Integer COLOR_GREY = 2;
	public static final Integer COLOR_GREEN = 3;
	public static final Integer COLOR_RED = 4;
	public static final Integer COLOR_YELLOW = 5;
	public static final Integer COLOR_WHITE = 6;
	public static final Integer COLOR_BLACK = 7;
	public static final Integer COLOR_INFO = 8;
	
	public static final String COLOR_BLUE_VIEW = "BLUE";
	public static final String COLOR_GREY_VIEW = "GREY";
	public static final String COLOR_GREEN_VIEW = "GREEN";
	public static final String COLOR_RED_VIEW = "RED";
	public static final String COLOR_YELLOW_VIEW = "YELLOW";
	public static final String COLOR_WHITE_VIEW = "WHITE";
	public static final String COLOR_BLACK_VIEW = "BLACK";
	public static final String COLOR_INFO_VIEW = "INFO";
	
	public static final Map<Integer, String> colorMap = new HashMap<>();
	public static final Map<String, Integer> colorReverseMap = new HashMap<>();
	static{
		colorMap.put(COLOR_BLUE, COLOR_BLUE_VIEW);
		colorMap.put(COLOR_GREY, COLOR_GREY_VIEW);
		colorMap.put(COLOR_GREEN, COLOR_GREEN_VIEW);
		colorMap.put(COLOR_RED, COLOR_RED_VIEW);
		colorMap.put(COLOR_YELLOW, COLOR_YELLOW_VIEW);
		colorMap.put(COLOR_WHITE, COLOR_WHITE_VIEW);
		colorMap.put(COLOR_BLACK, COLOR_BLACK_VIEW);
		colorMap.put(COLOR_INFO, COLOR_INFO_VIEW);
		
		colorReverseMap.put(COLOR_BLUE_VIEW, COLOR_BLUE);
		colorReverseMap.put(COLOR_GREY_VIEW, COLOR_GREY);
		colorReverseMap.put(COLOR_GREEN_VIEW, COLOR_GREEN);
		colorReverseMap.put(COLOR_RED_VIEW, COLOR_RED);
		colorReverseMap.put(COLOR_YELLOW_VIEW, COLOR_YELLOW);
		colorReverseMap.put(COLOR_WHITE_VIEW, COLOR_WHITE);
		colorReverseMap.put(COLOR_BLACK_VIEW, COLOR_BLACK);
		colorReverseMap.put(COLOR_INFO_VIEW, COLOR_INFO);
	}
	/**
	 * name: id
	 * type: Long 
	 * @Description: Primary key of badge.
	 */
	private Long id;
	/**
	 * name: name
	 * type: String 
	 * @Description:Name of the badge.
	 */
	private String name;
	/**
	 * name: color
	 * type: Integer 
	 * @Description: Color of badge.
	 * 1: blue
	 * 2: grey
	 * 3: green
	 * 4: red
	 * 5: yellow
	 * 6: white
	 * 7: black
	 * 8: Info
	 */
	private Integer color;
	private String colorView;
	
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
		this.colorView = colorMap.get(color);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColorView() {
		return colorView;
	}
}
