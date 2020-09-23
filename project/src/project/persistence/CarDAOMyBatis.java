package project.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.base.DAOMyBatisBase;
import common.domain.CarInfoVO;
import common.domain.CategoryVO;
import common.domain.OptionVO;

public class CarDAOMyBatis extends DAOMyBatisBase {

		private final String NS = "common.mapper.CarMapper";
		private SqlSession ses;
		
		/** 차량 판매글을 등록하는 insert */
		public int carInsert(CarInfoVO item) {
			try {
				ses = this.getSqlSessionFactory().openSession(true);
				int n = ses.insert(NS+".carInsert", item);
				return n;
			} finally {
				close(ses);
			}
		}
		
		/** 브랜드를 목록을 가져오는 select */
		public List<CategoryVO> brandSearchList(int val) {
			try {
				ses = this.getSqlSessionFactory().openSession();
				List<CategoryVO> blist = ses.selectList(NS + ".brandSearchList", val);
				return blist;
			} finally {
				close(ses);
			}
		}

		/** 모델 목록을 가져오는 select */
		public List<CategoryVO> modelSearchList(int model) {
			try {
				ses = this.getSqlSessionFactory().openSession();
				List<CategoryVO> mlist = ses.selectList(NS + ".modelSearchList", model);
				return mlist;
			} finally {
				close(ses);
			}

		}

		/** 세부모델 목록을 가져오는 select */
		public List<CategoryVO> dmodelSearchList(String dmodel) {
			try {
				ses = this.getSqlSessionFactory().openSession();
				List<CategoryVO> dlist = ses.selectList(NS+".dmodelSearchList", dmodel);
				return dlist;
			} finally {
				close(ses);
			}
			
		}

		/** 세부모델 이름으로 세부정보를 찾는 select */
		public CategoryVO searchByDemodel(String dmodel2) {
			try {
				ses = this.getSqlSessionFactory().openSession();
				CategoryVO dlist2 = ses.selectOne(NS+".searchByDemodel", dmodel2);
				return dlist2;
			} finally {
				close(ses);
			}
		}

		/** 옵션정보를 관계테이블에 insert */
		public int insertOptInfo(Map<String, Integer> p) {
			try {
				ses = this.getSqlSessionFactory().openSession(true);
				int optList = ses.insert(NS+".insertOptInfo", p);
				return optList;
			} finally {
				close(ses);
			}
		}
		
			// 판매 /////////////////////////////////////////////////////////////
		
		   /**차량 세부 정보*/
		   public CarInfoVO selectCarDetail(int idx) {
		      try {
		         ses=this.getSqlSessionFactory().openSession();
		         CarInfoVO vo=ses.selectOne(NS+".selectCarDetail",idx);
		         return vo;
		      }finally {
		         close(ses);
		      }
		   }//--------------------------------
		   
		   /**전체 차량 조회*/
		   public List<CarInfoVO> selectCarList() {
		      try {
		         ses=this.getSqlSessionFactory().openSession();
		         List<CarInfoVO> arr=ses.selectList(NS+".selectCarList");
		         return arr;
		      }finally {
		         close(ses);
		      }
		   }//--------------------------
		   
		   /**총 국내 차량 수 가져오기*/
		   public int getTotalCount() {
		      try {
		         ses=this.getSqlSessionFactory().openSession();
		         int cnt=ses.selectOne(NS+".getTotalCount");
		         return cnt;
		      }finally {
		         close(ses);
		      }
		   }//----------------------------
		   
		   /**총 해외 차량 수 가져오기*/
		   public int getO_TotalCount() {
		      try {
		         ses=this.getSqlSessionFactory().openSession();
		         int cnt=ses.selectOne(NS+".getO_TotalCount");
		         return cnt;
		      }finally {
		         close(ses);
		      }
		   }//----------------------------
		   
		   /**검색된 차량 세부코드로 바꿔오기*/
		   public List<Integer> changeCode(String search){
			   try {
				   ses=this.getSqlSessionFactory().openSession();
				   List<Integer> code=ses.selectList(NS+".changeCode",search);
				   return code;
			   }finally {
				   close(ses);
			   }
		   }
		   
		   /**검색된 차량 수 가져오기*/
		   public int getSearchCount(List<Integer> search) {
			   try {
				   ses=this.getSqlSessionFactory().openSession();
				   int cnt=ses.selectOne(NS+".getSearchCount",search);
				   return cnt;
			   }finally {
				   close(ses);
			   }
		   }
		   
		   /**사이즈바로 국내 차량 수 가져오기*/
		   public int getSideOptCount(Map<String,Object> carSize3) {
			   try {
				   ses=this.getSqlSessionFactory().openSession();
				   int n=ses.selectOne(NS+".getSideOptCount",carSize3);
				   return n;
			   }finally {
				   close(ses);
			   }
		   }
		   
		   /**사이드바로 해외 차량 수 가져오기*/
		   public int getO_SideOptCount(Map<String,Object> carSize3) {
			   try {
				   ses=this.getSqlSessionFactory().openSession();
				   System.out.println("DAO !!!!"+carSize3.get("carAge_max"));
				   int n=ses.selectOne(NS+".getO_SideOptCount",carSize3);
				   return n;
			   }finally {
				   close(ses);
			   }
		   }
		   
		   /**사이드바로 검색된 국내 차들만 출력하기*/
		   public List<CarInfoVO> carSideOptList(Map<String,Object> se){
			   try {
				   ses=this.getSqlSessionFactory().openSession();
				   System.out.println("DAO ses: "+ses);
				   List<CarInfoVO> arr= ses.selectList(NS+".carSideOptList", se);
				   return arr;
			   }finally {
				   close(ses);
			   }
		   }
		   
		   /**사이드바로 검색된 해외 차들만 출력하기*/
		   public List<CarInfoVO> O_carSideOptList(Map<String,Object> se){
			   try {
				   ses=this.getSqlSessionFactory().openSession();
				   System.out.println("DAO carAge_max: "+se.get("carAge_max"));
				   List<CarInfoVO> arr= ses.selectList(NS+".O_carSideOptList", se);
				   return arr;
			   }finally {
				   close(ses);
			   }
		   }
		   
		   /**선택한 옵션 있는 차량idx 가져오기*/
		   public List<String> carOptionList(List<String> opt_idx){
			   try {
				ses=getSqlSessionFactory().openSession();
				List<String> arr=ses.selectList(NS+".carOptionList",opt_idx);
				System.out.println("DAO 옵션: "+opt_idx.get(0));
				//System.out.println("DAO 옵션 반환: "+arr.get(0));
				return arr;
						
			} finally {
				close(ses);
			}
		   }

		   /**국내 차량 페이지 갯수만큼만 끊어서 조회하기 */
		   public List<CarInfoVO> listCar(Map<String, Integer> se) {
		      try {
		    	  ses=this.getSqlSessionFactory().openSession();
		    	  List<CarInfoVO> arr = ses.selectList(NS+".listCar",se);
		         return arr;
		      }finally {
		         close(ses);
		      }
		   }//----------------------------
		   
		   /**해외 차량 페이지 갯수만큼만 끊어서 조회하기 */
		   public List<CarInfoVO> O_listCar(Map<String, Integer> se) {
		      try {
		    	  ses=this.getSqlSessionFactory().openSession();
		    	  List<CarInfoVO> arr = ses.selectList(NS+".O_listCar",se);
		         return arr;
		      }finally {
		         close(ses);
		      }
		   }//----------------------------
		   
		   /**차량명으로 검색된 차들만 출력하기*/
		   public List<CarInfoVO> searchCarList(Map<String, Object> se){
			   try {
				   ses=this.getSqlSessionFactory().openSession();
				   List<CarInfoVO> arr=ses.selectList(NS+".searchCarList",se);
				   return arr;
			   }finally {
				   close(ses);
			   }
		   }

		   /**브랜드 코드로 모델리스트 출력하기*/
		   public List<CategoryVO> searchModelList(String b_code){

			   try {
				ses=this.getSqlSessionFactory().openSession();
				List<CategoryVO> arr=ses.selectList(NS+".searchModelList",b_code);
				return arr;
			} finally {
				close(ses);
			}
		   }

		   /**모델 코드로 세부모델 리스트 출력하기*/
		   public List<CategoryVO> searchDetailModelList(String m_code) {
			   
			   try {
				   ses=this.getSqlSessionFactory().openSession();
				   System.out.println("DAO M_CODE"+m_code);
				   List<CategoryVO> arr=ses.selectList(NS+".searchDetailModelList",m_code);
				   return arr;
			   }finally {
				   close(ses);
			   }
		   }
		   
		   /**idx번호로 옵션정보 가져오기*/
		   public List<OptionVO> selectOption(String idx) {
				try {
					ses=getSqlSessionFactory().openSession();
					List<OptionVO> arr=ses.selectList(NS+".selectOption",idx);
					return arr;
				}finally {
					close(ses);
				}
			}

		   
		   ////////////////////////////// 시세 ///////////////////////////////////////////
		   
		   /** 시세페이지에서 쓰는 조건별 검색 */
		   public List<CarInfoVO> carSearchByOption(Map<String,Object> mapperParamemter){
			   try {
				ses=this.getSqlSessionFactory().openSession();
				List<CarInfoVO> arr = ses.selectList(NS+".carSearchByOption",mapperParamemter);
				return arr;
			} finally {
				close(ses);
			}
		   }

		public List<Integer> findCarsByOpts(List<String> opt_idx) {
			try {
				ses=this.getSqlSessionFactory().openSession();
				List<Integer> arr = ses.selectList(NS+".findCarsByOpts",opt_idx);
				return arr;
			} finally {
				close(ses);
			}
		}

		public int findRel(Map<String, Object> map) {
			try {
				ses=this.getSqlSessionFactory().openSession();
				int judge = ses.selectOne(NS+".findRel",map);
				return judge;
			} finally {
				close(ses);
			}
		}
		
}


