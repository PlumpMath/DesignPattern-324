package com.yujin.demo.jsontest;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TagListBean extends BaseBean<List<TagListBean>>{

	private int scenicSpotsId;

	private String scenicSpotsTitle;

	private int scenicSpotsType;

	private String scenicSpotsbrief;

	private String scenicSpotsimageUrl;

	public void setScenicSpotsId(int scenicSpotsId){
	this.scenicSpotsId = scenicSpotsId;
	}
	public int getScenicSpotsId(){
	return this.scenicSpotsId;
	}
	public void setScenicSpotsTitle(String scenicSpotsTitle){
	this.scenicSpotsTitle = scenicSpotsTitle;
	}
	public String getScenicSpotsTitle(){
	return this.scenicSpotsTitle;
	}
	public void setScenicSpotsType(int scenicSpotsType){
	this.scenicSpotsType = scenicSpotsType;
	}
	public int getScenicSpotsType(){
	return this.scenicSpotsType;
	}
	public void setScenicSpotsbrief(String scenicSpotsbrief){
	this.scenicSpotsbrief = scenicSpotsbrief;
	}
	public String getScenicSpotsbrief(){
	return this.scenicSpotsbrief;
	}
	public void setScenicSpotsimageUrl(String scenicSpotsimageUrl){
	this.scenicSpotsimageUrl = scenicSpotsimageUrl;
	}
	public String getScenicSpotsimageUrl(){
	return this.scenicSpotsimageUrl;
	}
	
	@Override
    public String toString() {
        return "[" + "scenicSpotsId:" + scenicSpotsId + " scenicSpotsTitle:" + scenicSpotsTitle
                + " scenicSpotsType:" + scenicSpotsType + " scenicSpotsbrief:" + scenicSpotsbrief
                + " scenicSpotsimageUrl:" + scenicSpotsimageUrl + "]";
    }
	
	public static void main(String[] args) {
		String json = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"scenicSpotsId\": 123,\n" +
                "            \"scenicSpotsTitle\": \"圆明园\",\n" +
                "            \"scenicSpotsType\": 1,\n" +
                "            \"scenicSpotsbrief\": \"国粹明远，曾经的辉煌残存至今，悼念沉甸甸的历史。\",\n" +
                "            \"scenicSpotsimageUrl\": \"http://123.56.148.217:2020/bdfile/file/getFile.do?filename=/20160203/e35ed5a48fc472a80fedfea892432cc2.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"scenicSpotsId\": 123,\n" +
                "            \"scenicSpotsTitle\": \"圆明园\",\n" +
                "            \"scenicSpotsType\": 2,\n" +
                "            \"scenicSpotsbrief\": \"国粹明远，曾经的辉煌残存至今，悼念沉甸甸的历史。\",\n" +
                "            \"scenicSpotsimageUrl\": \"http://123.56.148.217:2020/bdfile/file/getFile.do?filename=/20160203/e35ed5a48fc472a80fedfea892432cc2.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"scenicSpotsId\": 123,\n" +
                "            \"scenicSpotsTitle\": \"圆明园\",\n" +
                "            \"scenicSpotsType\": 2,\n" +
                "            \"scenicSpotsbrief\": \"国粹明远，曾经的辉煌残存至今，悼念沉甸甸的历史。\",\n" +
                "            \"scenicSpotsimageUrl\": \"http://123.56.148.217:2020/bdfile/file/getFile.do?filename=/20160203/e35ed5a48fc472a80fedfea892432cc2.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"scenicSpotsId\": 123,\n" +
                "            \"scenicSpotsTitle\": \"圆明园\",\n" +
                "            \"scenicSpotsType\": 3,\n" +
                "            \"scenicSpotsbrief\": \"国粹明远，曾经的辉煌残存至今，悼念沉甸甸的历史。\",\n" +
                "            \"scenicSpotsimageUrl\": \"http://123.56.148.217:2020/bdfile/file/getFile.do?filename=/20160203/e35ed5a48fc472a80fedfea892432cc2.jpg\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"msg\": \"success\",\n" +
                "    \"code\": 0\n" +
                "}";
		Gson gson = new Gson();
		TagListBean bean = gson.fromJson(json, TagListBean.class);
		System.out.println(bean.toString());
	}
}
