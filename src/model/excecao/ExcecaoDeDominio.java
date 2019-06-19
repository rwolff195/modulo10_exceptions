package model.excecao;

public class ExcecaoDeDominio extends RuntimeException{

		private static final long serialVersionUID = 1L;
		
		public ExcecaoDeDominio (String msg) {
			super(msg);
		}

}
