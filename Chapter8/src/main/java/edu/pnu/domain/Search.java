package edu.pnu.domain;

public class Search {
	private String searchCondition;
	private String searchKeyword;
	
	public Search(String searchCondition, String searchKeyword) {
		super();
		// 검색범주
		this.searchCondition = searchCondition;
		// 검색 내용
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "Search [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	
}
