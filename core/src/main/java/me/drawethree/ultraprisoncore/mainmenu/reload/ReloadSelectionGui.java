package me.drawethree.ultraprisoncore.mainmenu.reload;

import me.drawethree.ultraprisoncore.UltraPrisonCore;
import me.drawethree.ultraprisoncore.utils.PlayerUtils;
import me.drawethree.ultraprisoncore.utils.SkullUtils;
import me.drawethree.ultraprisoncore.utils.compat.CompMaterial;
import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.Gui;
import me.lucko.helper.menu.scheme.MenuPopulator;
import me.lucko.helper.menu.scheme.MenuScheme;
import me.lucko.helper.text3.Text;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ReloadSelectionGui extends Gui {

	private static final MenuScheme LAYOUT_WHITE = new MenuScheme()
			.mask("011111110")
			.mask("110000011")
			.mask("100000001")
			.mask("110000011")
			.mask("011111110");

	private static final MenuScheme LAYOUT_RED = new MenuScheme()
			.mask("100000001")
			.mask("000000000")
			.mask("000000000")
			.mask("000000000")
			.mask("100000001");

	private static final MenuScheme CONTENT = new MenuScheme()
			.mask("000000000")
			.mask("000111000")
			.mask("001111100")
			.mask("000111000")
			.mask("000000000");

	private final UltraPrisonCore core;

	public ReloadSelectionGui(UltraPrisonCore core, Player player) {
		super(player, 5, "UltraPrisonCore - Reload Module");
		this.core = core;
	}

	@Override
	public void redraw() {
		if (isFirstDraw()) {

			MenuPopulator populator = LAYOUT_WHITE.newPopulator(this);

			while (populator.hasSpace()) {
				populator.accept(ItemStackBuilder.of(CompMaterial.WHITE_STAINED_GLASS_PANE.toItem()).name(" ").buildItem().build());
			}

			populator = LAYOUT_RED.newPopulator(this);

			while (populator.hasSpace()) {
				populator.accept(ItemStackBuilder.of(CompMaterial.RED_STAINED_GLASS_PANE.toItem()).name(" ").buildItem().build());
			}

			//AutoMiner
			this.setItem(12, ItemStackBuilder.of(Material.DIAMOND_PICKAXE).name("&e&lAutoMiner").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getAutoMiner());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lAutoMiner &amodule."));
			}));

			//Autosell
			this.setItem(13, ItemStackBuilder.of(SkullUtils.MONEY_SKULL.clone()).name("&e&lAutoSell").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getAutoSell());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lAutoSell &amodule."));
			}));

			//Enchants
			this.setItem(14, ItemStackBuilder.of(CompMaterial.ENCHANTED_BOOK.toItem()).name("&e&lEnchants").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getEnchants());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lEnchants &amodule."));
			}));

			//Gangs
			this.setItem(20, ItemStackBuilder.of(SkullUtils.GANG_SKULL.clone()).name("&e&lGangs").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getGangs());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lGangs &amodule."));
			}));

			//Gems
			this.setItem(21, ItemStackBuilder.of(Material.EMERALD).name("&e&lGems").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getGems());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lGems &amodule."));
			}));

			//Ranks
			this.setItem(22, ItemStackBuilder.of(SkullUtils.DIAMOND_R_SKULL.clone()).name("&e&lRanks").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getRanks());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lRanks &amodule."));
			}));

			//Prestiges
			this.setItem(23, ItemStackBuilder.of(SkullUtils.DIAMOND_P_SKULL.clone()).name("&e&lPrestiges").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getRanks());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lPrestiges &amodule."));
			}));

			//PickaxeLevels
			this.setItem(24, ItemStackBuilder.of(CompMaterial.EXPERIENCE_BOTTLE.toItem()).name("&e&lPickaxe Levels").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getPickaxeLevels());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lPickaxe Levels &amodule."));
			}));

			//Tokens
			this.setItem(30, ItemStackBuilder.of(SkullUtils.COIN_SKULL.clone()).name("&e&lTokens").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getTokens());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lTokens &amodule."));
			}));

			//Multipliers
			this.setItem(31, ItemStackBuilder.of(Material.GOLD_INGOT).name("&e&lMultipliers").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getMultipliers());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lMultipliers &amodule."));
			}));

			//Mines
			this.setItem(32, ItemStackBuilder.of(Material.DIAMOND_ORE).name("&e&lMines").lore("&7Click to reload this module.").build(() -> {
				this.core.reloadModule(this.core.getMines());
				this.getPlayer().sendMessage(Text.colorize("&aSuccessfully reloaded &e&lMines &amodule."));
			}));

			this.setItem(36, ItemStackBuilder.of(Material.BARRIER).name("&c&lClose").lore("&7Click to close the gui.").build(this::close));
			this.setItem(44, ItemStackBuilder.of(SkullUtils.HELP_SKULL.clone()).name("&e&lNeed more help?").lore("&7Right-Click to see plugin's Wiki", "&7Left-Click to join Discord Support.")
					.build(() -> {
						this.close();
						PlayerUtils.sendMessage(this.getPlayer(), " ");
						PlayerUtils.sendMessage(this.getPlayer(), Text.colorize("&eUltraPrisonCore - Wiki"));
						PlayerUtils.sendMessage(this.getPlayer(), Text.colorize("&7https://github.com/Drawethree/UltraPrisonCore/wiki"));
						PlayerUtils.sendMessage(this.getPlayer(), " ");
					}, () -> {
						this.close();
						PlayerUtils.sendMessage(this.getPlayer(), " ");
						PlayerUtils.sendMessage(this.getPlayer(), Text.colorize("&eUltraPrisonCore - Discord"));
						PlayerUtils.sendMessage(this.getPlayer(), Text.colorize("&7https://discord.com/invite/cssWTNK"));
						PlayerUtils.sendMessage(this.getPlayer(), " ");
					}));

		}
	}
}
