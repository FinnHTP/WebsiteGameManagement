import { useState } from "react";

const AccordionItem = ({ title, gameTypes }) => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <div className="border-b">
      <button
        className="w-full text-left text-white p-4 flex justify-between items-center"
        onClick={() => setIsOpen(!isOpen)}
      >
        <span>{title}</span>
        <span>{isOpen ? "-" : "+"}</span>
      </button>
      {isOpen && (
        <div className="p-4 text-white">
          {gameTypes.map((gameType, index) => (
            <div key={index} className="mb-2">
              <h3 className="font-semibold text-lg">{gameType.title}</h3>
              <ul className="list-disc pl-5 list-none">
                {gameType.games.map((game, i) => (
                  <li key={i} className="py-1">
                    {game}
                  </li>
                ))}
              </ul>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

const Accordion = () => {
  const items = [
    {
      title: "Action Games",
      gameTypes: [
        {
          games: ["Call of Duty", "Battlefield", "Halo"],
        },
        {
          games: ["Street Fighter", "Mortal Kombat", "Tekken"],
        },
      ],
    },
    {
      title: "Adventure Games",
      gameTypes: [
        {
          games: [
            "The Legend of Zelda",
            "Red Dead Redemption",
            "Assassin's Creed",
          ],
        },
        {
          games: ["Portal", "The Witness", "Baba Is You"],
        },
      ],
    },
  ];
  return (
    <div>
      {items.map((item, index) => (
        <AccordionItem
          key={index}
          title={item.title}
          gameTypes={item.gameTypes}
        />
      ))}
    </div>
  );
};

export default Accordion;
