package br.com.tech4music.musicws.shared;

public class MusicaDto {
        String id;
        String titulo;
        String artista;
        String album;
        String genero;
        Integer anoLancamento;
        String compositor;
    
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getTitulo() {
            return titulo;
        }
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
        public String getArtista() {
            return artista;
        }
        public void setArtista(String artista) {
            this.artista = artista;
        }
        public String getAlbum() {
            return album;
        }
        public void setAlbum(String album) {
            this.album = album;
        }
        public String getGenero() {
            return genero;
        }
        public void setGenero(String genero) {
            this.genero = genero;
        }
        public Integer getAnoLancamento() {
            return anoLancamento;
        }
        public void setAnoLancamento(Integer anoLancamento) {
            this.anoLancamento = anoLancamento;
        }
        public String getCompositor() {
            return compositor;
        }
        public void setCompositor(String compositor) {
            this.compositor = compositor;
        }               
}
