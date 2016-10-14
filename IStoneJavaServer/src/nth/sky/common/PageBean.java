package nth.sky.common;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {
	
	
	private List list; //Ҫ���ص�ĳһҳ������

	private int allRow;//���ݿ�������Ҫ����ܼ�¼����
	
	private int totalPage;//��ҳ��
	
	private int currentPage;//��ǰ�ڼ�ҳ
	
	private int pageSize;//ÿҳ������¼������
	
	
	private boolean isFirstPage;//�Ƿ�Ϊ��һҳ
	
	
	private boolean isLastPage;//�Ƿ�Ϊ���һҳ
	
	
	private boolean hasPreviousPage;//�Ƿ���ǰһҳ
	
	
	private boolean hasNextPage;//�Ƿ�����һҳ
	
	public PageBean() {
		super();
	}	
	
	public PageBean(List list, int allRow, int totalPage, int currentPage,
			int pageSize) {
		super();
		this.list = list;
		this.allRow = allRow;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public void init()
	{
		this.isFirstPage = isFirstPage();
		this.isLastPage = isLastPage();
		this.hasPreviousPage = isHasPreviousPage();
		this.hasNextPage = isHasNextPage();
	}
	
	/*
	 * ������ҳ��
	 */
	
	public static int countTotalPage(final int pageSize,final int allRow)
	{
		 int local_totalPage = allRow % pageSize == 0?allRow/pageSize:allRow/pageSize + 1;
		 return local_totalPage;
	}
	
	/*
	 * �����ѯ����ʼλ��
	 */
	public static int countOffset(final int pageSize, final int currentPage)
	{
		int offset = pageSize * (currentPage - 1) ;
		return offset;
	}
	/*
	 * ȷ����ǰҳ
	 */
	
	public static int countCurrentPage(int page)
	{
		final int curPage = (page <= 0 ?1:page);
		return curPage;
		
	}
	
	public boolean isFirstPage()
	{
		return currentPage == 1;
	}
	
	public boolean isLastPage()
	{
		return currentPage >= totalPage;
	}
	
	public boolean isHasPreviousPage()
	{
		return currentPage != 1;
	}
	
	public boolean isHasNextPage()
	{
		return currentPage < totalPage;
	}
/*
 * get and set methods 
 */
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}	
}

