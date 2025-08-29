package upload;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"http://127.0.0.1:3000", "http://127.0.0.1:4000"})
public class UploadRestController {
	
	@RequestMapping("/fileupload")
	String uploadResult(UploadDto dto) throws IOException {
		String savePath = "c:/upload/";
		MultipartFile file1 = dto.getF1();
		String originalFilename1 = file1.getOriginalFilename();
		file1.transferTo(new File(savePath + originalFilename1));
		
		MultipartFile file2 = dto.getF2();
		String originalFilename2 = file2.getOriginalFilename();
		file2.transferTo(new File(savePath + originalFilename2));
		
		return dto.getUploader() + " 회원이"
				+ originalFilename1 + " , "
				+ originalFilename2 + " 파일을 업로드했습니다. ";
	}
}
