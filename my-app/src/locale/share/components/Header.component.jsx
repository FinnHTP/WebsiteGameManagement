import React from "react";
import { useNavigate } from "react-router-dom";

const Header = () => {
  const navigate = useNavigate();
  return (
    <div>
      <ul className="flex bg-stone-900">
        <li className="mr-6 mt-2 ms-2">
          <button
            className="text-lg mt-1 text-gray-100 hover:text-yellow-500"
            onClick={() => navigate("/store")}
          >
            Store
          </button>
        </li>
        <li className="mr-6 mt-2 ms-2">
          <button
            className="text-lg mt-1 text-gray-100 hover:text-yellow-500"
            onClick={() => navigate("/category")}
          >
            Category
          </button>
        </li>
        <li className="mr-6 mt-2 ms-2">
          <button
            className="text-lg mt-1 text-gray-100 hover:text-yellow-500"
            onClick={() => navigate("/forum")}
          >
            Forum
          </button>
        </li>
        <li className="mr-6 mt-2 ms-2">
          <button
            className="text-lg mt-1 text-gray-100 hover:text-yellow-500"
            onClick={() => navigate("/contact")}
          >
            Contact
          </button>
        </li>
        <li className="ml-auto mr-2 pb-2 ">
          <div class="relative">
            <img
              class="w-12 h-12 rounded-full"
              src="/image/avartar-anime-43.jpg"
              alt=""
            />
            <span class="bottom-0 left-7 absolute  w-3.5 h-3.5 bg-green-400 border-2 border-white dark:border-gray-800 rounded-full"></span>
          </div>
        </li>
      </ul>
    </div>
  );
};

export default Header;
