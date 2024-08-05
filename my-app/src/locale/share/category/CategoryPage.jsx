import React from "react";
import Game from "../components/category/Game.component";
import Filter from "../components/category/Filter.component";

const CategoryPage = () => {
  return (
    <div>
      <div>
        <div className="form-control ms-20 mt-7">
          <input
            type="text"
            placeholder="Search Game"
            className="bg-customInputBg1 text-customTypeEdition px-5 py-2 rounded-full"
          />
        </div>
        <h5 className="text-gray-50 py-3 ms-20 font-light">
          <span className="text-neutral-500">Show</span>: New Release
        </h5>
        <div className="flex flex-wrap ms-20">
          <div className="w-9/12 p-2">
            <Game />
          </div>
          <div className="w-3/12 p-2">
            <Filter />
          </div>
        </div>
      </div>
    </div>
  );
};

export default CategoryPage;
