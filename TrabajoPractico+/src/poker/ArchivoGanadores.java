package poker;
import java.io.File;
import java.io.FilenameFilter;



public class ArchivoGanadores implements FilenameFilter {
	
	private String extension;
	
	public ArchivoGanadores(String extension){
		this.setExtension(extension);
	}
		
		
		public String getExtension() {
			return extension;
		}
		

		public void setExtension(String extension) {
			this.extension = extension;
		}
	
		public boolean accept(File file, String str){
			return  str.endsWith(this.getExtension());
		}

}











	


