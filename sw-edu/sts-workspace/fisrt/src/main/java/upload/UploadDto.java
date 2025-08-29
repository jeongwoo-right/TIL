package upload;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadDto {
	String uploader, desc;
	MultipartFile f1, f2;
}
