package co.micol.prj.book.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.book.mapper.BookMapper;
import co.micol.prj.book.service.BookService;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.DataSource;

public class BookServiceImpl implements BookService {
	//데이터 소스 관계를 커넥션에 연결 : true 꼭 하기 -> auto커밋을 해달라
	private SqlSession SqlSession = DataSource.getInstance().openSession(true);
	//mapper.xml연결
	private BookMapper map = SqlSession.getMapper(BookMapper.class);
	
	@Override
	public List<BookVO> bookSelectList() {
		// 전체 리스트
		return map.bookSelectList();
	}

	@Override
	public BookVO bookSelect(BookVO vo) {
		// 한권 조회
		return map.bookSelect(vo);
	}

	@Override
	public int bookInsert(BookVO vo) {
		// 책을 입력하는 곳
		return map.bookInsert(vo);
	}

	@Override
	public int bookDelete(BookVO vo) {
		// 책 삭제
		return map.bookDelete(vo);
	}

	@Override
	public int bookUpdate(BookVO vo) {
		// 책 수정
		return map.bookUpdate(vo);
	}

}
