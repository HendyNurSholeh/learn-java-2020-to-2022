package hyns.listbook.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Books {
    @NonNull
    private Integer id;
    @NonNull
    @Range(min = 1000, max = 2022, message = "tahun harus antara {min} sampai {max}")
    private Integer tahun;
    @NonNull
    @NotBlank(message = "judul tidak boleh kosong")
    private String judul;
    @NonNull
    @NotBlank(message = "penulis tidak boleh kosong")
    private String penulis;
    @NonNull
    @NotBlank(message = "penerbit tidak boleh kosong")
    private String penerbit;
}
