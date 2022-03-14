export type MovieResponse = {
  content: Movie[];
  size:number;
  totalpages: number;
};

export type Movie = {
  id: number;
  title: string;
  subTitle: string;
  year: number;
  imgUrl: string;
  synopsis: string;
  genreDTO: GenreDTO;
};

export type GenreDTO = {
  id: number;
  name: string;
};

export type Reviews = {
  reviews: string;
};

export type GenreId = {
  genreId: number;
};
