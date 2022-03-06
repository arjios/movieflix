import "./styles.css";

export default function Logincard() {
  return (
    <>
      <div className="base-card card-container">
        <div className="card-title">Login</div>
        <form className="card-form">
          <label>
            <input className="form-email" type="email" name="email" placeholder="email"/>
          </label>
          <label >
            <input className="form-senha" type="password" name="senha" placeholder="senha"/>
          </label>
          <label >
            <input className="form-button" type="submit" value="Fazer Login" />
          </label>
        </form>
      </div>
    </>
  );
}
