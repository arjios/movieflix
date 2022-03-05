
import Banner from "components/Banner";
import Logincard from "components/Logincard";

import "./styles.css";

export default function Home() {
  return (
    <>
      <div className="home-container">
        <div className="home-banner">
          <Banner />
        </div>
        <div className="home-card">
          <Logincard />
        </div>
      </div>
    </>
  );
}
