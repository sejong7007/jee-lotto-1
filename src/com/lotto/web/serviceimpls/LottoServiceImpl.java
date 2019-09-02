package com.lotto.web.serviceimpls;


import java.util.Random;

import com.lotto.web.daoimpls.LottoDaoImpl;
import com.lotto.web.daos.LottoDao;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.services.LottoService;

	public class LottoServiceImpl implements LottoService {

		
		private LottoDao dao;
		
		public LottoServiceImpl() {
		dao = new LottoDaoImpl();
		}
		
		@Override
		public void createLotto(LottoBean param) {
			LottoBean lotto = new LottoBean();
			lotto.setBall(createBall());
			lotto.setLotteryNum(createLotteryNum());
			lotto.setLottoSeq(createLottoSeq());
			dao.insertLotto(lotto);
			
		}

		@Override
		public String createLottoSeq() {
			Random ran = new Random();
			int a = ran.nextInt(9)+1;
			int b = ran.nextInt(9)+1;	
			int c = ran.nextInt(9)+1;
			int d = ran.nextInt(9)+1;
			String msg = String.format("No.%d%d%d%d", a, b, c, d);
			return msg;
		}

		@Override
		public String createBall() {
			Random ran = new Random();
			String a = ran.nextInt(44)+1 + "";
			return a;
		}

		@Override
		public String createLotteryNum() {
			Random ran = new Random();
			String msg = "";
			String[] arr = new String[6];
			for(int i=0 ; i<7 ; i++) {
				arr[i] = ran.nextInt(44)+1 + "";
			}
			msg = String.format("%s, %s, %s, %s, %s, %s", arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
			return msg;
		}

		
		

}
