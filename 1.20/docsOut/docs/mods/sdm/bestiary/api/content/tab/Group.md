# Group

A group to which other elements can be added.

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.sdm.bestiary.api.content.tab.Group;
```


## Implemented Interfaces
Group implements the following interfaces. That means all methods defined in these interfaces are also available in Group

- [IInfoTabContent](/mods/sdm/bestiary/api/content/IInfoTabContent)

## Constructors


```zenscript
new Group(consumer as Consumer<Group>) as Group
```
| Parameter |                               Type                                |
|-----------|-------------------------------------------------------------------|
| consumer  | Consumer&lt;[Group](/mods/sdm/bestiary/api/content/tab/Group)&gt; |



```zenscript
new Group(component as Component, id as string) as Group
```
| Parameter |                   Type                   |
|-----------|------------------------------------------|
| component | [Component](/vanilla/api/text/Component) |
| id        | string                                   |



## Methods

:::group{name=addContent}

Return Type: [Group](/mods/sdm/bestiary/api/content/tab/Group)

```zenscript
Group.addContent(content as IInfoTabContent) as Group
```

| Parameter |                               Type                                |
|-----------|-------------------------------------------------------------------|
| content   | [IInfoTabContent](/mods/sdm/bestiary/api/content/IInfoTabContent) |


:::

:::group{name=addContent}

Return Type: [Group](/mods/sdm/bestiary/api/content/tab/Group)

```zenscript
Group.addContent(content as stdlib.List<IInfoTabContent>) as Group
```

| Parameter |                                         Type                                         |
|-----------|--------------------------------------------------------------------------------------|
| content   | stdlib.List&lt;[IInfoTabContent](/mods/sdm/bestiary/api/content/IInfoTabContent)&gt; |


:::

:::group{name=addInfoContent}

Return Type: [IInfoTabContent](/mods/sdm/bestiary/api/content/IInfoTabContent)

```zenscript
Group.addInfoContent(content as InfoContent) as IInfoTabContent
```

| Parameter |                           Type                            |
|-----------|-----------------------------------------------------------|
| content   | [InfoContent](/mods/sdm/bestiary/api/content/InfoContent) |


:::

:::group{name=setIcon}

Return Type: [Group](/mods/sdm/bestiary/api/content/tab/Group)

```zenscript
Group.setIcon(icon as Icon) as Group
```

| Parameter |              Type               |
|-----------|---------------------------------|
| icon      | [Icon](/mods/sdm/bestiary/Icon) |


:::


## Properties

|   Name    |                                         Type                                         | Has Getter | Has Setter |                             Description                             |
|-----------|--------------------------------------------------------------------------------------|------------|------------|---------------------------------------------------------------------|
| collapse  | boolean                                                                              | true       | true       |                                                                     |
| component | [Component](/vanilla/api/text/Component)                                             | true       | true       |                                                                     |
| content   | stdlib.List&lt;[IInfoTabContent](/mods/sdm/bestiary/api/content/IInfoTabContent)&gt; | true       | true       |                                                                     |
| icon      | [Icon](/mods/sdm/bestiary/Icon)                                                      | true       | true       |                                                                     |
| id        | string                                                                               | true       | true       | The ID is needed to create links to tabs through different widgets. |

