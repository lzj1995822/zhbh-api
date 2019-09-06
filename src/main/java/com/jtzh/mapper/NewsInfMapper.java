package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.BrowsingCount;
import com.jtzh.entity.BrowsingPage;
import com.jtzh.entity.NewsBrowsingHistory;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.NewsInf;
import com.jtzh.pojo.NewsDepReq;
import com.jtzh.pojo.NewsInf2Pagination;
import com.jtzh.pojo.NewsInfPagination;

public interface NewsInfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsInf record);

    int insertSelective(NewsInf record);

    NewsInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsInf record);

    int updateByPrimaryKey(NewsInf record);
    
    // 查询总数
 	int selectTotal(@Param("page") NewsInfPagination param);

 	// 分页查询
 	List<NewsInf> selectInfo(@Param("page") NewsInfPagination param);

 	// 查询具体的路
  	NewsInf selectNews(Integer id);
 	
 	// 查询具体的路
 	NewsInf selectNewsOnlyDep(NewsDepReq param);

 	// 删除
 	int deleteNews(Integer id);
 	
 	// 更新阅读次数
  	int updateReadNum(Integer id);
  	
	// 查询具体的路
 	List<NewsInf> selectNewsList(int ids[]);
 	
 	// 分页查询
  	List<NewsInf> selectInfo2(@Param("page") NewsInf2Pagination param);
  	
  	// 查询总数
  	int selectTotal2(@Param("page") NewsInf2Pagination param);
  	
  	int insertNewsInf(NewsInf record);
  	
  	// 查询总数
   	int selectTotal3();
   	
   	// 更新阅读次数
   	int updateHasReceiveNum(Integer id);

	// 更新通知公告状态
	int updateState(NewsInf param);

	// 插入浏览记录
	int insertBrowsingHistory(NewsBrowsingHistory param);

	// 根据newsid获取浏览记录
	List<NewsBrowsingHistory> getBrowsingHistory( BrowsingPage param);

	// 根据newsid获取浏览记录total
	int getBrowsingHistoryTotal(BrowsingPage param);

	// 根据newsid和name获取浏览记录
	List<NewsBrowsingHistory> getBrowsingList(BrowsingPage param);
	// 根据newsid和name获取浏览记录total
	int getBrowsingListTotal(BrowsingPage param);

}