import React from "react";
import RecentTopImageComponent from "../components/store/RecentTopImage.component";
import CarouselGame from "../components/store/CarouselGame.component";

const StorePage = () => {
  return (
    <div>
      <RecentTopImageComponent />
      <div className="rounded-lg bg-stone-800 p-4 mx-auto mt-5 w-10/12">
        <CarouselGame />
      </div>
    </div>
  );
};

export default StorePage;
