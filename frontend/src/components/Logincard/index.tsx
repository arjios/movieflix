import "./styles.css";
import { useForm } from "react-hook-form";

type FormData = {
  email: string;
  password: string;
};

export default function Logincard() {
  const { register, handleSubmit } = useForm<FormData>();

  const onSubmit = (data: FormData) => {
    console.log(data);
  };

  return (
    <>
      <div className="base-card card-container">
        <div className="card-title">Login</div>
        <form className="card-form" onSubmit={handleSubmit(onSubmit)}>
          <label>
            <input
              className="form-email"
              type="email"
              placeholder="email"
            {...register("email")}
            />
          </label>
          <label>
            <input
              className="form-senha"
              type="password"
              placeholder="senha"
              {...register("password")}
            />
          </label>
          <label>
            <input className="form-button" type="submit" value="Fazer Login" />
          </label>
        </form>
      </div>
    </>
  );
}
