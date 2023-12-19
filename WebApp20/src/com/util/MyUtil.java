/*=========================
	MyUtil.java
	- 게시판 페이징 처리
 =========================*/

// check
// 지금 같이 확인해보고자 하는 페이징 처리 기법은
// 다양한 방법들 중 하나(그나마 쉬운 것)이다.
// 학습을 마친 이후에 꼭 추가적으로 개념을 정리하고
// 확장시키고, 다른 방법들을 찾아보고 공부해야 한다.

package com.util;

public class MyUtil
{
	// ■ 전체 페이지 수를 구하는 메소드
	// numPerPage : 한 페이지에 표시할 데이터(게시물)의 수
	// dataCount : 전체 데이터(게시물) 수
	public int getPageCount(int numPerPage, int dataCount)
	{
		int pageCount = 0;
		
		pageCount = dataCount / numPerPage;
		
		if(dataCount % numPerPage != 0)
			pageCount++;
		
		return pageCount;
	}
	// 한 페이지에 10 개의 게시물을 출력할 때
	// 총 32 개의 게시물을 페이지로 구성하기 위해서는
	// 32 / 10 의 연산을 수행하여 결과 3을 얻을 수 있다.
	// -> pageCount = dataCount / numPerPage;
	// 그런데 이 때, 나머지 2개의 게시물을 출력해 주기 위해서는
	// 페이지 하나가 더 필요하다.
	// -> pageCount++;
	
	// ■ 페이징 처리 기능의 메소드
	public String pageIndexList(int currentPage, int totalPage, String listUrl)
	{
		StringBuffer strList = new StringBuffer();
		
		int numPerBlock = 10;
		
		int currentPageSetup;
		
		int page;
		int n;
		
		if(currentPage==0)
			return "";
		
		if(listUrl.indexOf("?") != -1)
		{
			listUrl = listUrl + "&";
		}
		else
		{
			listUrl = listUrl + "?";
		}
		
		currentPageSetup = (currentPage / numPerBlock) * numPerBlock;
		
		if(currentPage % numPerBlock == 0)
		{
			currentPageSetup = currentPageSetup - numPerBlock;
			//currentPageSetup -= numPerBlock
		}
		
		// 1페이지(맨처음으로)
		if( (totalPage>numPerBlock) && (currentPageSetup>0) )
		{
			strList.append(" <a href='" + listUrl + "pageNum=1'>1</a>");
		}
		
		// Prev(이전으로)
		n = currentPage - numPerBlock;
		
		if( (totalPage>numPerBlock) && (currentPageSetup>0))
		{
			strList.append(" <a href='" + listUrl + "pageNum=" + n +"'>Prev</a>");
		}
		
		// 각 페이지 바로가기
		page = currentPageSetup + 1;
		
		while( (page<=totalPage) && (page<=currentPageSetup + numPerBlock))
		{
			if(page==currentPage)
			{
				strList.append(" <span style='color:orange; font-weight:bold;'>" + page + "</span>");
			}
			else
			{
				strList.append(" <a href='" + listUrl + "pageNum=" + page + "'>" + page + "</a>");
			}
			page++;
		}
		
		// Next(다음으로)
		n = currentPage + numPerBlock;
		if((totalPage-currentPageSetup) > numPerBlock)
		{
			strList.append(" <a href='" + listUrl + "pageNum=" + n +"'>Next</a>");
		}
		
		// 마지막 페이지(맨마지막으로)
		if((totalPage>numPerBlock) && (currentPageSetup+numPerBlock) < totalPage)
		{
			strList.append(" <a href='" + listUrl + "pageNum=" + totalPage + "'>" + totalPage + "</a>");
		}
		return strList.toString();
	}
}





































