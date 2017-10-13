package co.i014114.www.talleriii.ArrayPhotos;

/**
 * Created by root on 13/10/17.
 */

public class Photos {
    public String getPhotos() {
        x = (int) (Math.random() * 7);
        ArrayPhotos = new String[8];
        ArrayPhotos[0] = "https://organicthemes.com/demo/profile/files/2012/12/profile_img.png";
        ArrayPhotos[1] = "http://www.lapiragua.co/wp-content/uploads/2017/10/seleccion-colombia-1.jpg";
        ArrayPhotos[2] = "http://cde.americadeportes.pe/americandeportes-390x245-408715.jpg";
        ArrayPhotos[3] = "http://static.pulzo.com/images/20171011021756/gettyimages-859948744-900x485.jpg?itok=1507718455";
        ArrayPhotos[4] = "https://ep01.epimg.net/deportes/imagenes/2017/10/11/actualidad/1507735965_634049_1507736429_noticia_normal.jpg";
        ArrayPhotos[5] = "http://ligadeportiva.com/wp-content/uploads/2017/06/Nacional-derroto-a-Jaguares.jpg";
        ArrayPhotos[6] = "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/58757.jpeg";
        ArrayPhotos[7] = "https://i0.wp.com/www.sopitas.com/wp-content/uploads/2017/10/poster-last-jedi.jpg?resize=860%2C450";
        return ArrayPhotos[x];
    }
    private int x;
    private String[] ArrayPhotos;
}